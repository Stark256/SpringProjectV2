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

import ua.com.model.bilder.MealPredicateBuilder;
import ua.entity.Meal;
import ua.entity.Meal_;
import ua.model.filter.MealFilter;
import ua.model.view.MealView;
import ua.repository.MealViewRepository;


@Repository
public class MealViewRepositoryImpl implements MealViewRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Page<MealView> findAll(MealFilter filter, Pageable pageable) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<MealView> criteriaQuery = criteriaBuilder.createQuery(MealView.class);
		Root<Meal> root = criteriaQuery.from(Meal.class);
		criteriaQuery.multiselect(root.get(Meal_.id), root.get(Meal_.title), root.get(Meal_.description),
				root.get(Meal_.price), root.get(Meal_.photoUrl), root.get(Meal_.version), root.get(Meal_.cuisine),
				root.get(Meal_.weight));
		MealPredicateBuilder builder = new MealPredicateBuilder(filter, criteriaBuilder, root);
		Predicate predicate = builder.toPredicate();
		if (predicate != null) {
			criteriaQuery.where(predicate);
		}
		criteriaQuery.orderBy(QueryUtils.toOrders(pageable.getSort(), root, criteriaBuilder));
		criteriaQuery.orderBy(criteriaBuilder.asc(root.get(Meal_.title)));
		criteriaQuery.distinct(true);
		List<MealView> views = entityManager.createQuery(criteriaQuery).setFirstResult(pageable.getPageNumber()).setMaxResults(pageable.getPageSize()).getResultList();
		CriteriaQuery<Long> criteriaQueryCount = criteriaBuilder.createQuery(Long.class);
		Root<Meal> rootCount = criteriaQueryCount.from(Meal.class);
		criteriaQueryCount.select(criteriaBuilder.count(rootCount));
		MealPredicateBuilder builderCount = new MealPredicateBuilder(filter, criteriaBuilder, rootCount);
		Predicate predicateCount = builderCount.toPredicate();
		if (predicateCount != null) {
			criteriaQueryCount.where(predicateCount);
		}
		return PageableExecutionUtils.getPage(views, pageable, () -> entityManager.createQuery(criteriaQueryCount).getSingleResult());
	}
}