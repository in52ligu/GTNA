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
 * DeterministicRandom.java
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
package gtna.util;

import java.util.Random;

/**
 * @author Tim
 *
 */
public class DeterministicRandom extends Random {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    private Long configuredSeed;

    /**
     * Create a standard RNG without configured seed
     */
=======
    private long seed;

>>>>>>> provides a configurable random number generator
=======
    private Long seed;
=======
    private Long configuredSeed;
>>>>>>> usage, persisting, loading of the deterministic-rng possible

    /**
     * Create a standard RNG without configured seed
     */
>>>>>>> null checks
    public DeterministicRandom() {
	super();
    }
    
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> null checks
    /**
     * Create a standard RNG and initialize with the given seed
     * @param seed
     */
    public DeterministicRandom(Long seed) {
	super();
	if(seed != null) {
	    this.setSeed(seed);
<<<<<<< HEAD
<<<<<<< HEAD
	    this.configuredSeed = seed;
	}
    }
    
    /**
     * reset RNG with the saved seed, iff a seed was given earlier
     */
    public void resetSeed() {
	if(configuredSeed != null)
	    this.setSeed(configuredSeed);
    }
    
    public void setNewSeed(Long seed) {
	if(seed != null) {
	    this.setSeed(seed);
	    this.configuredSeed = seed;
	}
=======
    public DeterministicRandom(long seed) {
	super(seed);
	this.seed = seed;
=======
	    this.seed = seed;
=======
	    this.configuredSeed = seed;
>>>>>>> usage, persisting, loading of the deterministic-rng possible
	}
>>>>>>> null checks
    }
    
    /**
     * reset RNG with the saved seed, iff a seed was given earlier
     */
    public void resetSeed() {
	if(configuredSeed != null)
	    this.setSeed(configuredSeed);
    }
    
<<<<<<< HEAD
    public void setNewSeed(long seed) {
	this.setSeed(seed);
>>>>>>> provides a configurable random number generator
=======
    public void setNewSeed(Long seed) {
	if(seed != null) {
	    this.setSeed(seed);
	    this.configuredSeed = seed;
	}
>>>>>>> null checks
    }
    
    /**
     * Returns the seed of the RNG
<<<<<<< HEAD
<<<<<<< HEAD
     * @return	Seed or <b>NULL</b> of no seed is set
     */
    public Long getConfiguredSeed() {
	return configuredSeed;
=======
     * @return	Seed or <b>null<b> of no seed is set
=======
     * @return	Seed or <b>NULL</b> of no seed is set
>>>>>>> null checks
     */
<<<<<<< HEAD
    public long getSeed() {
	return seed;
>>>>>>> provides a configurable random number generator
=======
    public Long getConfiguredSeed() {
	return configuredSeed;
>>>>>>> usage, persisting, loading of the deterministic-rng possible
    }
    
    
}
