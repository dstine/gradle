/*
 * Copyright 2007-2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gradle.api.internal.artifacts;

import org.apache.ivy.plugins.resolver.DependencyResolver;
import org.gradle.api.artifacts.repositories.ArtifactRepository;
import org.gradle.api.artifacts.repositories.FlatDirectoryArtifactRepository;
import org.gradle.api.artifacts.repositories.IvyArtifactRepository;
import org.gradle.api.artifacts.repositories.MavenArtifactRepository;
import org.gradle.api.internal.artifacts.repositories.FixedResolverArtifactRepository;

/**
 * Factory for {@link ArtifactRepository} implementations.
 *
 * Differs from {@link org.gradle.api.artifacts.dsl.RepositoryFactory} in that this is internal and does not provide
 * API for configuring the repositories at creation time. {@link org.gradle.api.artifacts.dsl.RepositoryFactory} is the DSL
 * layer on top of this internal factory.
 */
public interface BaseRepositoryFactory {

    ArtifactRepository createRepository(Object userDescription);

    FlatDirectoryArtifactRepository createFlatDirRepository();

    MavenArtifactRepository createMavenLocalRepository();

    MavenArtifactRepository createMavenCentralRepository();

    IvyArtifactRepository createIvyRepository();

    MavenArtifactRepository createMavenRepository();

    DependencyResolver toResolver(ArtifactRepository repository);

    FixedResolverArtifactRepository createResolverBackedRepository(DependencyResolver resolver);
}
