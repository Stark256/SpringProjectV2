package ua.validation.validator;

import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import ua.repository.OpenCloseRepository;
import ua.validation.annotation.UniqueOpenClose;


@Component
public class OpenCloseValidator implements ConstraintValidator<UniqueOpenClose, String>{

	private final OpenCloseRepository repository;
	
	public OpenCloseValidator(OpenCloseRepository repository) {
		this.repository = repository;
	}

	@Override
	public void initialize(UniqueOpenClose constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Pattern pattern = Pattern.compile("^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$");
		Matcher matcher = pattern.matcher(value);
		if (!matcher.matches()) {
			return true;
		}
		pattern = Pattern.compile("^[0-9]:[0-5][0-9]$");
		matcher = pattern.matcher(value);
		return repository.findByTime(LocalTime.parse(matcher.matches() ? "0" + value : value)) == null;
	}
}