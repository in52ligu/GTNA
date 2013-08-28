/* ===========================================================
 * GTNA : Graph-Theoretic Network Analyzer
 * ===========================================================
 *
 * (C) Copyright 2009-2011, by Benjamin Schiller (P2P, TU Darmstadt)
 * and Contributors
 *
 * Project Info:  http://www.p2p.tu-darmstadt.de/research/gtna/
 *
 * GTNA is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * GTNA is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * ---------------------------------------
 * SamplingThesis.java
 * ---------------------------------------
 * (C) Copyright 2009-2011, by Benjamin Schiller (P2P, TU Darmstadt)
 * and Contributors 
 *
 * Original Author: Tim;
 * Contributors:    -;
 *
 * Changes since 2011-05-17
 * ---------------------------------------
 *
 */
package gtna;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import gtna.networks.Network;
import gtna.networks.model.BarabasiAlbert;
import gtna.networks.model.CondonAndKarp;
import gtna.networks.model.ErdosRenyi;
import gtna.networks.model.Regular;
import gtna.networks.model.WattsStrogatz;
import gtna.transformation.Transformation;
import gtna.transformation.sampling.SamplingAlgorithmFactory;
import gtna.transformation.sampling.SamplingAlgorithmFactory.SamplingAlgorithm;
import gtna.transformation.sampling.subgraph.ColorSampledSubgraph;
import gtna.transformation.sampling.subgraph.ColoredHeatmapSampledSubgraph;
import gtna.transformation.sampling.subgraph.ExtractSampledSubgraph;

/**
 * @author Tim
 * 
 */
public class WFSampling {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		SamplingAlgorithm alg;
		int dim, size;
		boolean rev, uni;
		double sd, seed, p1, p2;
		String dir;
		
		if(args.length == 1){
			if(args[0].equalsIgnoreCase("help")){
				printHelp();
				System.exit(0);
			}
		}
		
		for (String s : args) {
			// parse sampling algorithm properties
			if (s.startsWith("sampling=")) {
				String sa = s.substring(9);
				// TODO get sampling algorithm from enumeration
			} else if (s.startsWith("dimension=")) {
				dim = Integer.parseInt(s.substring(10));
			} else if (s.startsWith("revisiting=")) {
				if (s.equalsIgnoreCase("revisiting=true")) {
					rev = true;
				} else {
					rev = false;
				}
			} else if (s.startsWith("scaledown=")){
				sd = Double.parseDouble(s.substring(10));
			} else if(s.startsWith("randomSeed=")){
				String seedDate = s.substring(11);
				seedDate.matches("[0-3][0-9]\\.[0-1][0-9]\\.[0-9][0-9][0-9][0-9]");
				DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
	            Date seeddate =  df.parse(seedDate);
	            seed = seeddate.getTime();
			}
			
			// readable folder?
			else if (s.startsWith("loadDir=")){
				dir = s.substring(8);
			} else {
				printHelp();
				System.exit(0);
			}
		}

	}

	private static void printHelp() {
		System.out.println("Usage:"
				+ "sampling=<samplingalgorithm> dimension=<how many walker> scaledown=<sample size in percentage> revisiting=<true/false> randomSeed=<dd.mm.yyyy>"
				+ "loadDir=<directory with prepared networks>");
	}

	private static Transformation[] instantiateSamplingTransformation(
			SamplingAlgorithm alg, double scaledown, int dimension,
			boolean revisiting, Long randomSeed, String subgraphing) {
		Transformation samplingalgorithm = SamplingAlgorithmFactory
				.getInstanceOf(alg, scaledown, revisiting, dimension,
						randomSeed);

		Transformation sg;
		if (subgraphing.equalsIgnoreCase("subgraph")) {
			sg = new ExtractSampledSubgraph();
		} else if (subgraphing.equalsIgnoreCase("coloring")) {
			sg = new ColorSampledSubgraph();
		} else if (subgraphing.equalsIgnoreCase("heatmap")) {
			sg = new ColoredHeatmapSampledSubgraph();
		} else {
			throw new IllegalArgumentException(
					"sg must be one of {subgraph, coloring, heatmap}");
		}
		Transformation[] t1 = new Transformation[] { samplingalgorithm, sg };
		return t1;
	}
	
}