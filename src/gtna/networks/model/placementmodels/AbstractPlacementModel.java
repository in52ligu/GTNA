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
 * PlacementModel.java
 * ---------------------------------------
 * (C) Copyright 2009-2011, by Benjamin Schiller (P2P, TU Darmstadt)
 * and Contributors 
 *
 * Original Author: Flipp;
 * Contributors:    -;
 *
 * Changes since 2011-05-17
 * ---------------------------------------
 *
 */
package gtna.networks.model.placementmodels;

/**
 * @author Flipp
 * 
 */
public abstract class AbstractPlacementModel {
	private double width;
	private double height;
	private String key;
	private String[] additionalConfigKeys;
	private String[] additionalConfigValues;

	/**
	 * @param hotspots
	 * @return
	 */
	public abstract Point[] place(int hotspots);

	/**
	 * @return
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @return
	 */
	public double getWidth() {
		return width;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * @return
	 */
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return
	 */
	public String[] getConfigKeys() {
		return Util.addToArray(new String[] { "KEY", "WIDTH", "HEIGHT" },
				additionalConfigKeys);
	}

	public void setAdditionalConfigKeys(String[] arr) {
		additionalConfigKeys = arr;
	}

	public void setAdditionalConfigValues(String[] arr) {
		additionalConfigValues = arr;
	}

	/**
	 * @return
	 */
	public String[] getConfigValues() {
		return Util.addToArray(new String[] { getKey(),
				Double.toString(getWidth()), Double.toString(getHeight()) },
				additionalConfigValues);
	}

}
