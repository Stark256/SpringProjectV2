package ua.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.query.QueryUtils;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import ua.com.model.bilder.CafePredicateBuilder;
import ua.entity.Cafe;
import ua.entity.Cafe_;
import ua.model.filter.CafeFilter;
import ua.model.view.CafeIndexView;
import ua.repository.CafeViewRepository;

@Repository
public class CafeViewRepositoryImpl implements CafeViewRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Page<CafeIndexView> findAll(CafeFilter filter, Pageable pageable) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CafeIndexView> criteriaQuery = criteriaBuilder.createQuery(CafeIndexView.class);
		Root<Cafe> root = criteriaQuery.from(Cafe.class);
		criteriaQuery.multiselect(root.get(Cafe_.id), root.get(Cafe_.rate), root.get(Cafe_.name), root.get(Cafe_.photoUrl), root.get(Cafe_.version), root.get(Cafe_.address), root.get(Cafe_.shortDescription), root.get(Cafe_.type));
		CafePredicateBuilder builder = new CafePredicateBuilder(filter, criteriaBuilder, root);
		Predicate predicate = builder.toPredicate();
		if (predicate != null) {
			criteriaQuery.where(predicate);
		}
		criteriaQuery.orderBy(QueryUtils.toOrders(pageable.getSort(), root, criteriaBuilder));
		criteriaQuery.orderBy(criteriaBuilder.desc(root.get(Cafe_.rate)));
		List<CafeIndexView> views = entityManager.createQuery(criteriaQuery).setFirstResult(pageable.getPageNumber()).setMaxResults(pageable.getPageSize()).getResultList();
		CriteriaQuery<Long> criteriaQueryCount = criteriaBuilder.createQuery(Long.class);
		Root<Cafe> rootCount = criteriaQueryCount.from(Cafe.class);
		criteriaQueryCount.select(criteriaBuilder.count(rootCount));
		CafePredicateBuilder builderCount = new CafePredicateBuilder(filter, criteriaBuilder, rootCount);
		Predicate predicateCount = builderCount.toPredicate();
		if (predicateCount != null) {
			criteriaQueryCount.where(predicateCount);
		}
		return PageableExecutionUtils.getPage(views, pageable, () -> entityManager.createQuery(criteriaQueryCount).getSingleResult());
	}
}