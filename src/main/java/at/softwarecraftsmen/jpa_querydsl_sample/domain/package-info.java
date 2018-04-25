@QueryEntities(value = {AbstractPersistable.class, AbstractAuditable.class})
package at.softwarecraftsmen.jpa_querydsl_sample.domain;

import com.querydsl.core.annotations.QueryEntities;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.domain.AbstractPersistable;