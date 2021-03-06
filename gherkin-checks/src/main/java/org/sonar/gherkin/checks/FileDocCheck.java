/*
 * SonarQube Cucumber Gherkin Analyzer
 * Copyright (C) 2016-2017 David RACODON
 * david.racodon@gmail.com
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
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.gherkin.checks;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.gherkin.api.tree.FeatureDeclarationTree;
import org.sonar.plugins.gherkin.api.visitors.DoubleDispatchVisitorCheck;
import org.sonar.squidbridge.annotations.SqaleConstantRemediation;


@Rule(
  key = "file-doc-check",
  name = "Deepalee Doc check",
  priority = Priority.MINOR,
  tags = {Tags.CONVENTION})
@SqaleConstantRemediation("10min")

public class FileDocCheck extends DoubleDispatchVisitorCheck {
	
	private static final String Doc_Check_Word = "fin";
	
	@Override
	public void visitFeatureDeclaration(FeatureDeclarationTree tree) {
	    if (tree!=null && null!=tree.description() && null!=tree.description().text() && tree.description().text().toLowerCase().contains(Doc_Check_Word)) {
	    	addPreciseIssue(tree.prefix(), "Do Not use fin word in documentation.");
	    }
  }

}
