package com.epam.geometry.observer;

import com.epam.geometry.entity.ConeParameters;
import com.epam.geometry.entity.Point;
import com.epam.geometry.logic.Calculator;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ConeObserverTests {

    private static final double DEFAULT_AREA = 2.0;
    private static final double DEFAULT_VOLUME = 4.4;
    private static final double UPDATED_AREA = 3.0;
    private static final double UPDATED_VOLUME = 5.4;
    private static final double SECOND_UPDATED_AREA = 4.1;
    private static final double SECOND_UPDATED_VOLUME = 6.2;
    private static final double UPDATED_HEIGHT = 7.0;
    private static final double UPDATED_RADIUS = 3.0;
    private static Calculator calculatorMock = mock(Calculator.class);
    private static final double DELTA = 0.1;
    
    @Test
    public void testUpdateShouldCalculateConeParametersWhenConeObservableSupplied(){
        /*Given*/
        Point centre = new Point(1.0, 1.0, 1.0);
        ConeObservable CONE = new ConeObservable(1, centre, 5.0, 2.0);
        when(calculatorMock.area(CONE)).thenReturn(DEFAULT_AREA);
        when(calculatorMock.volume(CONE)).thenReturn(DEFAULT_VOLUME);
        when(calculatorMock.isSituatedOnTheAxisSurface(CONE)).thenReturn(false);
        ConeObserver coneObserver = ConeObserver.getInstance(calculatorMock);
        CONE.addObserver(coneObserver);
        /*When*/
        ConeParameters actual = coneObserver.getParameters(CONE.getId());
        /*then*/
        Assert.assertNotNull(actual);
        Assert.assertEquals(DEFAULT_AREA, actual.getArea(), DELTA);
        Assert.assertEquals(DEFAULT_VOLUME, actual.getVolume(), DELTA);
        Assert.assertFalse(actual.isSituatedOnTheAxisSurface());
        verify(calculatorMock).area(CONE);
        verify(calculatorMock).volume(CONE);
        verify(calculatorMock).isSituatedOnTheAxisSurface(CONE);
        verifyNoMoreInteractions(calculatorMock);
    }
    @Test
    public void testUpdateShouldUpdateConeParametersWhenHeightIsChanged(){
        /*Given*/
        Point centre = new Point(-1.0, 4.0, 3.3);
        ConeObservable CONE = new ConeObservable(2, centre, 4.0, 2.0);
        when(calculatorMock.area(CONE)).thenReturn(DEFAULT_AREA).thenReturn(UPDATED_AREA);
        when(calculatorMock.volume(CONE)).thenReturn(DEFAULT_VOLUME).thenReturn(UPDATED_VOLUME);
        when(calculatorMock.isSituatedOnTheAxisSurface(CONE)).thenReturn(false).thenReturn(false);
        ConeObserver coneObserver = ConeObserver.getInstance(calculatorMock);
        CONE.addObserver(coneObserver);
        CONE.setHeight(UPDATED_HEIGHT);
        /*When*/
        ConeParameters actual = coneObserver.getParameters(CONE.getId());
        /*then*/
        Assert.assertNotNull(actual);
        Assert.assertEquals(UPDATED_AREA, actual.getArea(), DELTA);
        Assert.assertEquals(UPDATED_VOLUME, actual.getVolume(), DELTA);
        Assert.assertFalse(actual.isSituatedOnTheAxisSurface());
        verify(calculatorMock, times(2)).area(CONE);
        verify(calculatorMock, times(2)).volume(CONE);
        verify(calculatorMock, times(2)).isSituatedOnTheAxisSurface(CONE);
        verifyNoMoreInteractions(calculatorMock);
    }
    @Test
    public void testUpdateShouldUpdateConeParametersWhenRadiusIsChanged(){
        /*Given*/
        Point centre = new Point(-1.0, 4.0, 3.3);
        ConeObservable CONE = new ConeObservable(3, centre, 4.0, 2.0);
        when(calculatorMock.area(CONE)).thenReturn(DEFAULT_AREA).thenReturn(UPDATED_AREA);
        when(calculatorMock.volume(CONE)).thenReturn(DEFAULT_VOLUME).thenReturn(UPDATED_VOLUME);
        when(calculatorMock.isSituatedOnTheAxisSurface(CONE)).thenReturn(false).thenReturn(false);
        ConeObserver coneObserver = ConeObserver.getInstance(calculatorMock);
        CONE.addObserver(coneObserver);
        CONE.setHeight(UPDATED_HEIGHT);
        /*When*/
        ConeParameters actual = coneObserver.getParameters(CONE.getId());
        /*then*/
        Assert.assertNotNull(actual);
        Assert.assertEquals(UPDATED_AREA, actual.getArea(), DELTA);
        Assert.assertEquals(UPDATED_VOLUME, actual.getVolume(), DELTA);
        Assert.assertFalse(actual.isSituatedOnTheAxisSurface());
        verify(calculatorMock, times(2)).area(CONE);
        verify(calculatorMock, times(2)).volume(CONE);
        verify(calculatorMock, times(2)).isSituatedOnTheAxisSurface(CONE);
        verifyNoMoreInteractions(calculatorMock);
    }
    @Test
    public void testUpdateShouldUpdateConeParametersWhenCentrePointIsChanged(){
        /*Given*/
        Point centre = new Point(-1.0, 4.0, 3.3);
        Point newCentre = new Point(2.4, 0.0 , 3.3);
        ConeObservable CONE = new ConeObservable(4, centre, 4.0, 2.0);
        when(calculatorMock.area(CONE)).thenReturn(DEFAULT_AREA).thenReturn(DEFAULT_AREA);
        when(calculatorMock.volume(CONE)).thenReturn(DEFAULT_VOLUME).thenReturn(DEFAULT_VOLUME);
        when(calculatorMock.isSituatedOnTheAxisSurface(CONE)).thenReturn(false).thenReturn(true);
        ConeObserver coneObserver = ConeObserver.getInstance(calculatorMock);
        CONE.addObserver(coneObserver);
        CONE.setCentre(newCentre);
        /*When*/
        ConeParameters actual = coneObserver.getParameters(CONE.getId());
        /*then*/
        Assert.assertNotNull(actual);
        Assert.assertEquals(DEFAULT_AREA, actual.getArea(), DELTA);
        Assert.assertEquals(DEFAULT_VOLUME, actual.getVolume(), DELTA);
        Assert.assertTrue(actual.isSituatedOnTheAxisSurface());
        verify(calculatorMock, times(2)).area(CONE);
        verify(calculatorMock, times(2)).volume(CONE);
        verify(calculatorMock, times(2)).isSituatedOnTheAxisSurface(CONE);
        verifyNoMoreInteractions(calculatorMock);
    }
    @Test
    public void testUpdateShouldUpdateConeParametersWhenHeightAndRadiusAreChanged(){
        /*Given*/
        Point centre = new Point(-1.0, 4.0, 3.3);
        ConeObservable CONE = new ConeObservable(5, centre, 4.0, 2.0);
        when(calculatorMock.area(CONE))
                .thenReturn(DEFAULT_AREA)
                .thenReturn(UPDATED_AREA)
                .thenReturn(SECOND_UPDATED_AREA);
        when(calculatorMock.volume(CONE))
                .thenReturn(DEFAULT_VOLUME)
                .thenReturn(UPDATED_VOLUME)
                .thenReturn(SECOND_UPDATED_VOLUME);
        when(calculatorMock.isSituatedOnTheAxisSurface(CONE))
                .thenReturn(false)
                .thenReturn(false)
                .thenReturn(false);
        ConeObserver coneObserver = ConeObserver.getInstance(calculatorMock);
        CONE.addObserver(coneObserver);
        CONE.setHeight(UPDATED_HEIGHT);
        CONE.setRadius(UPDATED_RADIUS);
        /*When*/
        ConeParameters actual = coneObserver.getParameters(CONE.getId());
        /*then*/
        Assert.assertNotNull(actual);
        Assert.assertEquals(SECOND_UPDATED_AREA, actual.getArea(), DELTA);
        Assert.assertEquals(SECOND_UPDATED_VOLUME, actual.getVolume(), DELTA);
        Assert.assertFalse(actual.isSituatedOnTheAxisSurface());
        verify(calculatorMock, times(3)).area(CONE);
        verify(calculatorMock, times(3)).volume(CONE);
        verify(calculatorMock, times(3)).isSituatedOnTheAxisSurface(CONE);
        verifyNoMoreInteractions(calculatorMock);
    }
    @Test
    public void testUpdateShouldUpdateConeParametersWhenHeightAndCentrePointAreChanged(){
        /*Given*/
        Point centre = new Point(-1.0, 4.0, 3.3);
        Point newCentre = new Point(2.1, 2.5, 0.0);
        ConeObservable CONE = new ConeObservable(6, centre, 4.0, 2.0);
        when(calculatorMock.area(CONE))
                .thenReturn(DEFAULT_AREA)
                .thenReturn(UPDATED_AREA)
                .thenReturn(UPDATED_AREA);
        when(calculatorMock.volume(CONE))
                .thenReturn(DEFAULT_VOLUME)
                .thenReturn(UPDATED_VOLUME)
                .thenReturn(UPDATED_VOLUME);
        when(calculatorMock.isSituatedOnTheAxisSurface(CONE))
                .thenReturn(false)
                .thenReturn(false)
                .thenReturn(true);
        ConeObserver coneObserver = ConeObserver.getInstance(calculatorMock);
        CONE.addObserver(coneObserver);
        CONE.setHeight(UPDATED_HEIGHT);
        CONE.setCentre(newCentre);
        /*When*/
        ConeParameters actual = coneObserver.getParameters(CONE.getId());
        /*then*/
        Assert.assertNotNull(actual);
        Assert.assertEquals(UPDATED_AREA, actual.getArea(), DELTA);
        Assert.assertEquals(UPDATED_VOLUME, actual.getVolume(), DELTA);
        Assert.assertTrue(actual.isSituatedOnTheAxisSurface());
        verify(calculatorMock, times(3)).area(CONE);
        verify(calculatorMock, times(3)).volume(CONE);
        verify(calculatorMock, times(3)).isSituatedOnTheAxisSurface(CONE);
        verifyNoMoreInteractions(calculatorMock);
    }
    @Test
    public void testUpdateShouldUpdateConeParametersWhenRadiusAndCentrePointAreChanged(){
        /*Given*/
        Point centre = new Point(-1.0, 4.0, 3.3);
        Point newCentre = new Point(0.0, 4.2, 1.3);
        ConeObservable CONE = new ConeObservable(7, centre, 4.0, 2.0);
        when(calculatorMock.area(CONE))
                .thenReturn(DEFAULT_AREA)
                .thenReturn(UPDATED_AREA)
                .thenReturn(UPDATED_AREA);
        when(calculatorMock.volume(CONE))
                .thenReturn(DEFAULT_VOLUME)
                .thenReturn(UPDATED_VOLUME)
                .thenReturn(UPDATED_VOLUME);
        when(calculatorMock.isSituatedOnTheAxisSurface(CONE))
                .thenReturn(false)
                .thenReturn(false)
                .thenReturn(true);
        ConeObserver coneObserver = ConeObserver.getInstance(calculatorMock);
        CONE.addObserver(coneObserver);
        CONE.setRadius(UPDATED_RADIUS);
        CONE.setCentre(newCentre);
        /*When*/
        ConeParameters actual = coneObserver.getParameters(CONE.getId());
        /*then*/
        Assert.assertNotNull(actual);
        Assert.assertEquals(UPDATED_AREA, actual.getArea(), DELTA);
        Assert.assertEquals(UPDATED_VOLUME, actual.getVolume(), DELTA);
        Assert.assertTrue(actual.isSituatedOnTheAxisSurface());
        verify(calculatorMock, times(3)).area(CONE);
        verify(calculatorMock, times(3)).volume(CONE);
        verify(calculatorMock, times(3)).isSituatedOnTheAxisSurface(CONE);
        verifyNoMoreInteractions(calculatorMock);
    }
    @Test
    public void testUpdateShouldUpdateConeParametersWhenRadiusAndHeightAndCentrePointAreChanged(){
        /*Given*/
        Point centre = new Point(-1.0, 4.0, 3.3);
        Point newCentre = new Point(1.5, 0.0, 4.8);
        ConeObservable CONE = new ConeObservable(8, centre, 4.0, 2.0);
        when(calculatorMock.area(CONE))
                .thenReturn(DEFAULT_AREA)
                .thenReturn(UPDATED_AREA)
                .thenReturn(SECOND_UPDATED_AREA)
                .thenReturn(SECOND_UPDATED_AREA);
        when(calculatorMock.volume(CONE))
                .thenReturn(DEFAULT_VOLUME)
                .thenReturn(UPDATED_VOLUME)
                .thenReturn(SECOND_UPDATED_VOLUME)
                .thenReturn(SECOND_UPDATED_VOLUME);
        when(calculatorMock.isSituatedOnTheAxisSurface(CONE))
                .thenReturn(false)
                .thenReturn(false)
                .thenReturn(false)
                .thenReturn(true);
        ConeObserver coneObserver = ConeObserver.getInstance(calculatorMock);
        CONE.addObserver(coneObserver);
        CONE.setHeight(UPDATED_HEIGHT);
        CONE.setRadius(UPDATED_RADIUS);
        CONE.setCentre(newCentre);
        /*When*/
        ConeParameters actual = coneObserver.getParameters(CONE.getId());
        /*then*/
        Assert.assertNotNull(actual);
        Assert.assertEquals(SECOND_UPDATED_AREA, actual.getArea(), DELTA);
        Assert.assertEquals(SECOND_UPDATED_VOLUME, actual.getVolume(), DELTA);
        Assert.assertTrue(actual.isSituatedOnTheAxisSurface());
        verify(calculatorMock, times(4)).area(CONE);
        verify(calculatorMock, times(4)).volume(CONE);
        verify(calculatorMock, times(4)).isSituatedOnTheAxisSurface(CONE);
        verifyNoMoreInteractions(calculatorMock);
    }
}
