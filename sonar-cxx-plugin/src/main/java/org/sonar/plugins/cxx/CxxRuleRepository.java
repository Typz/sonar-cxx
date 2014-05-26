/*
 * Sonar C++ Plugin (Community)
 * Copyright (C) 2010 Neticoa SAS France
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.plugins.cxx;

import org.sonar.api.rules.AnnotationRuleParser;
import org.sonar.api.rules.Rule;
import org.sonar.api.rules.RuleRepository;
import org.sonar.cxx.checks.CheckList;

import com.google.common.collect.ImmutableList;

import java.util.List;
import org.sonar.api.Properties;
import org.sonar.api.Property;
import org.sonar.api.config.PropertyDefinition;
import org.sonar.api.PropertyField;
import org.sonar.api.PropertyType;
import org.sonar.plugins.cxx.compiler.CxxCompilerGccRuleRepository;
import org.sonar.plugins.cxx.compiler.CxxCompilerVcRuleRepository;
import org.sonar.plugins.cxx.cppcheck.CxxCppCheckRuleRepository;
import org.sonar.plugins.cxx.externalrules.CxxExternalRuleRepository;
import org.sonar.plugins.cxx.pclint.CxxPCLintRuleRepository;
import org.sonar.plugins.cxx.rats.CxxRatsRuleRepository;
import org.sonar.plugins.cxx.valgrind.CxxValgrindRuleRepository;
import org.sonar.plugins.cxx.veraxx.CxxVeraxxRuleRepository;

public class CxxRuleRepository extends RuleRepository {

  private static final String REPOSITORY_NAME = "Sonar";

  private final AnnotationRuleParser annotationRuleParser;

  public CxxRuleRepository(AnnotationRuleParser annotationRuleParser) {
    super(CheckList.REPOSITORY_KEY, CxxLanguage.KEY);
    setName(REPOSITORY_NAME);
    this.annotationRuleParser = annotationRuleParser;
  }

  @Override
  public List<Rule> createRules() {
    return annotationRuleParser.parse(CheckList.REPOSITORY_KEY, CheckList.getChecks());
  }

}
