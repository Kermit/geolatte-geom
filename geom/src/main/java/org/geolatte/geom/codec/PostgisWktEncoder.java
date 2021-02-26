/*
 * This file is part of the GeoLatte project.
 *
 *     GeoLatte is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     GeoLatte is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with GeoLatte.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) 2010 - 2011 and Ownership of code is shared by:
 * Qmino bvba - Romeinsestraat 18 - 3001 Heverlee  (http://www.qmino.com)
 * Geovise bvba - Generaal Eisenhowerlei 9 - 2140 Antwerpen (http://www.geovise.com)
 */

package org.geolatte.geom.codec;

import org.geolatte.geom.Position;
import org.geolatte.geom.PositionSequence;

/**
 * Encodes geometries to Postgis WKT/EWKT representations.
 *
 * <p>This class is not thread-safe.</p>
 *
 * @author Karel Maesen, Geovise BVBA, 2011
 */
class PostgisWktEncoder extends BaseWktEncoder {

    /**
     * Constructs an instance.
     */
    public PostgisWktEncoder() {
        super(new PostgisWktDialect());
    }

    public PostgisWktEncoder(PostgisWktDialect dialect) {
        super(dialect);
    }

    protected <P extends Position> double[] createCoordinateBuffer(PositionSequence<P> positions) {
        return new double[positions.getCoordinateDimension()];
    }

    protected <P extends Position> void setCoordinatesToWrite(PositionSequence<P> positions, int pos, double[] coords) {
        for (int i = 0; i < positions.getCoordinateDimension(); i++) {
            coords[i] = positions.getPositionN(pos).getCoordinate(i);
        }
    }
}
