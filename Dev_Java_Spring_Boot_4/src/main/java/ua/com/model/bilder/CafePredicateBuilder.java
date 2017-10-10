package ua.com.model.bilder;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ua.entity.Cafe;
import ua.entity.Cafe_;
import ua.entity.OpenClose;
import ua.entity.OpenClose_;
import ua.model.filter.CafeFilter;



public class CafePredicateBuilder {
	
	private final CafeFilter filter;

	private final CriteriaBuilder criteriaBuilder;

	private final Root<Cafe> root;

	private final List<Predicate> predicates = new ArrayList<>();
	
	public CafePredicateBuilder(CafeFilter filter, CriteriaBuilder criteriaBuilder, Root<Cafe> root) {
		this.filter = filter;
		this.criteriaBuilder = criteriaBuilder;
		this.root = root;
	}
	
	public Predicate toPredicate() {
		search();
		findByMinRate();
		findByMaxRate();
		findByTypes();
		findByMinOpen();
		findByMaxOpen();
		findByMinClose();
		findByMaxClose();
		return criteriaBuilder.and(predicates.stream().toArray(Predicate[]::new));
	}

	private void search() {
		if (!filter.getSearch().isEmpty()) {
			predicates.add(criteriaBuilder.like(root.get(Cafe_.name), filter.getSearch() + "%"));
		}
	}
	
	private void findByMinRate() {
		if (!filter.getMinRate().isEmpty()) {
			predicates.add(criteriaBuilder.ge(root.get(Cafe_.rate), new BigDecimal(filter.getMinRate().replace(',', '.'))));
		}
	}

	private void findByMaxRate() {
		if (!filter.getMaxRate().isEmpty()) {
			predicates.add(criteriaBuilder.le(root.get(Cafe_.rate), new BigDecimal(filter.getMaxRate().replace(',', '.'))));
		}
	}

	private void findByTypes() {
		if (!filter.getTypes().isEmpty()) {
			predicates.add(root.get(Cafe_.type).in(filter.getTypes()));
		}
	}
	
	private void findByMinOpen() {
		if (!filter.getMinOpen().isEmpty()) {
			Join<Cafe, OpenClose> join = root.join(Cafe_.open);
			predicates.add(criteriaBuilder.greaterThanOrEqualTo(join.get(OpenClose_.time), LocalTime.parse(filter.getMinOpen())));
		}
	}

	private void findByMaxOpen() {
		if (!filter.getMaxOpen().isEmpty()) {
			Join<Cafe, OpenClose> join = root.join(Cafe_.open);
			predicates.add(criteriaBuilder.lessThanOrEqualTo(join.get(OpenClose_.time), LocalTime.parse(filter.getMaxOpen())));
		}
	}
	
	private void findByMinClose() {
		if (!filter.getMinClose().isEmpty()) {
			Join<Cafe, OpenClose> join = root.join(Cafe_.close);
			predicates.add(criteriaBuilder.greaterThanOrEqualTo(join.get(OpenClose_.time), LocalTime.parse(filter.getMinClose())));
		}
	}

	private void findByMaxClose() {
		if (!filter.getMaxClose().isEmpty()) {
			Join<Cafe, OpenClose> join = root.join(Cafe_.close);
			predicates.add(criteriaBuilder.lessThanOrEqualTo(join.get(OpenClose_.time), LocalTime.parse(filter.getMaxClose())));
		}
	}
	
}