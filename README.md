# spring-data-jpa-querydsl-sample

Sample project to demonstrate how to resolve issues with missing `QAbstractPersistable` in generated querydsl meta-model classes.

## Issues

see: [DATAJPA-1282: Meta-model classes no longer contained in binaries](https://jira.spring.io/browse/DATAJPA-1282)

## Background

Since the 2.x version, the artifacts for [Spring Data JPA](https://projects.spring.io/spring-data-jpa/) do not contain the compiled querydsl meta-model classes `QAbstractPersistable` and `QAbstractAuditable` anymore.

This will lead to compile errors in the generated Q-source files with the following messages.

```bash
/target/generated-sources/java/at/softwarecraftsmen/jpa_querydsl_sample/domain/QUser.java:22: error: cannot find symbol
    public final org.springframework.data.jpa.domain.QAbstractPersistable _super = new org.springframework.data.jpa.domain.QAbstractPersistable(this);
                                                    ^
  symbol:   class QAbstractPersistable
  location: package org.springframework.data.jpa.domain
  
[ERROR] target/generated-sources/java/at/softwarecraftsmen/jpa_querydsl_sample/domain/QUser.java:[22,53] cannot find symbol
  symbol:   class QAbstractPersistable
  location: package org.springframework.data.jpa.domain
```

## Solution

Till the fix versions will be released, this repo shows a convenient workaround/fix.

Providing a simple *package-info.java* file inside the domain package, where your entities are located, with the following content resolves the problem.

```java
@QueryEntities(value = {AbstractPersistable.class, AbstractAuditable.class})
package at.softwarecraftsmen.jpa_querydsl_sample.domain;

import com.querydsl.core.annotations.QueryEntities;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.domain.AbstractPersistable;
```

## Contact

Klaus UNGER <klaus.unger@software-craftsmen.at>