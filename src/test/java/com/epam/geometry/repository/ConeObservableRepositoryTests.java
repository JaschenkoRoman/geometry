package com.epam.geometry.repository;

import com.epam.geometry.comparator.*;
import com.epam.geometry.entity.Point;
import com.epam.geometry.logic.Calculator;
import com.epam.geometry.observer.ConeObservable;
import com.epam.geometry.repository.specification.*;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;


public class ConeObservableRepositoryTests {
    private static List<ConeObservable> data = Arrays.asList(
            new ConeObservable(1, new Point(1.2, 3.3, 5.5), 5.5, 2.0),
            new ConeObservable(2, new Point(-2.4, 4.8, 2.1), 1.8, 3.3),
            new ConeObservable(3, new Point(1.7, -4.1, -1.5), 7.2, 1.6),
            new ConeObservable(4, new Point(4.8, -2.2, 4.9), 6.4, 2.8),
            new ConeObservable(5, new Point(-0.8, 5.2, -2.5), 4.9, 3.5),
            new ConeObservable(6, new Point(-1.5, -3.0, -4.5), 2.5, 1.5),
            new ConeObservable(7, new Point(-3.6, -1.8, 5.1), 3.9, 2.3),
            new ConeObservable(8, new Point(2.7, -4.4, 3.5), 6.9, 3.8),
            new ConeObservable(9, new Point(1.8, -2.2, 4.9), 7.2, 1.7),
            new ConeObservable(10, new Point(6.5, 4.2, 7.5), 5.1, 2.4)
    );

    private static final ConeObservableRepository repository = new ConeObservableRepository();
    private static final Calculator calculator = new Calculator();

    @BeforeEach
    public void setUp(){
        repository.saveAll(data);
    }
    @AfterEach
    public void tearDown(){
        repository.removeAll(data);
    }

    @Test
    public void testShouldQueryConeObservableWithAllSpecification() {
        /*Given*/
        Specification<ConeObservable> specification = new AllSpecification();
        List<ConeObservable> expected = data;
        /*When*/
        List<ConeObservable> actual = repository.query(specification);
        /*Then*/
        Assert.assertNotNull(actual);
        assertThat(actual, IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
        assertThat(expected, IsIterableContainingInAnyOrder.containsInAnyOrder(actual.toArray()));
    }
    @Test
    public void testShouldQueryAllConeObservableWithAllSpecificationOrderedByIdComparator() {
        /*Given*/
        Specification<ConeObservable> specification = new AllSpecification();
        Comparator<ConeObservable> comparator = new IdComparator();
        List<ConeObservable> expected = data;
        /*When*/
        List<ConeObservable> actual = repository.query(specification, comparator);
        /*Then*/
        Assert.assertNotNull(actual);
        assertThat(actual, IsIterableContainingInOrder.contains(expected.toArray()));
        assertThat(expected, IsIterableContainingInOrder.contains(actual.toArray()));
    }
    @Test
    public void testShouldSaveConeObservableToRepository() {
        /*Given*/
        Point centre = new Point(0.0, 0.2, 4.9);
        ConeObservable givenItem = new ConeObservable(4, centre, 3.4, 2.8);
        Specification<ConeObservable> specification = new SpecificationById(4);
        List<ConeObservable> expected = Arrays.asList(givenItem);
        /*When*/
        repository.save(givenItem);
        List<ConeObservable> actual = repository.query(specification);
        /*Then*/
        Assert.assertNotNull(actual);
        assertThat(actual, IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
        assertThat(expected, IsIterableContainingInAnyOrder.containsInAnyOrder(actual.toArray()));

    }
    @Test
    public void testShouldQueryAllConeObservableWithRangeXSpecification() {
        /*Given*/
        Specification<ConeObservable> specification = new SpecificationByRangeX(2.0, 5.0);
        List<ConeObservable> expected = Arrays.asList(data.get(3),data.get(7));
        /*When*/
        List<ConeObservable> actual = repository.query(specification);
        /*Then*/
        Assert.assertNotNull(actual);
        assertThat(actual, IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
        assertThat(expected, IsIterableContainingInAnyOrder.containsInAnyOrder(actual.toArray()));
    }
    @Test
    public void testShouldQueryAllConeObservableWithRangeXSpecificationOrderedByAreaComparator() {
        /*Given*/
        Comparator<ConeObservable> comparator = new AreaComparator(calculator);
        Specification<ConeObservable> specification = new SpecificationByRangeX(2.0, 5.0);
        List<ConeObservable> expected = Arrays.asList(data.get(3),data.get(7));
        /*When*/
        List<ConeObservable> actual = repository.query(specification, comparator);
        /*Then*/
        Assert.assertNotNull(actual);
        assertThat(actual, IsIterableContainingInOrder.contains(expected.toArray()));
        assertThat(expected, IsIterableContainingInOrder.contains(actual.toArray()));
    }
    @Test
    public void testShouldQueryAllConeObservableWithRangeYSpecification() {
        /*Given*/
        Specification<ConeObservable> specification = new SpecificationByRangeY(-2.5, 2.5);
        List<ConeObservable> expected = Arrays.asList(data.get(3),data.get(6), data.get(8));
        /*When*/
        List<ConeObservable> actual = repository.query(specification);
        /*Then*/
        Assert.assertNotNull(actual);
        assertThat(actual, IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
        assertThat(expected, IsIterableContainingInAnyOrder.containsInAnyOrder(actual.toArray()));
    }
    @Test
    public void testShouldQueryAllConeObservableWithRangeYSpecificationOrderedByHeightComparator() {
        /*Given*/
        Comparator<ConeObservable> comparator = new HeightComparator();
        Specification<ConeObservable> specification = new SpecificationByRangeY(-2.5, 2.5);
        List<ConeObservable> expected = Arrays.asList(data.get(6),data.get(3), data.get(8));
        /*When*/
        List<ConeObservable> actual = repository.query(specification, comparator);
        /*Then*/
        Assert.assertNotNull(actual);
        assertThat(actual, IsIterableContainingInOrder.contains(expected.toArray()));
        assertThat(expected, IsIterableContainingInOrder.contains(actual.toArray()));
    }
    @Test
    public void testShouldQueryAllConeObservableWithRangeZSpecification() {
        /*Given*/
        Specification<ConeObservable> specification = new SpecificationByRangeZ(5.0, 10.0);
        List<ConeObservable> expected = Arrays.asList(data.get(0),data.get(6), data.get(9));
        /*When*/
        List<ConeObservable> actual = repository.query(specification);
        /*Then*/
        Assert.assertNotNull(actual);
        assertThat(actual, IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
        assertThat(expected, IsIterableContainingInAnyOrder.containsInAnyOrder(actual.toArray()));
    }
    @Test
    public void testShouldQueryAllConeObservableWithRangeZSpecificationOrderedByIdComparator() {
        /*Given*/
        Comparator<ConeObservable> comparator = new IdComparator();
        Specification<ConeObservable> specification = new SpecificationByRangeZ(5.0, 10.0);
        List<ConeObservable> expected = Arrays.asList(data.get(0),data.get(6), data.get(9));
        /*When*/
        List<ConeObservable> actual = repository.query(specification, comparator);
        /*Then*/
        Assert.assertNotNull(actual);
        assertThat(actual, IsIterableContainingInOrder.contains(expected.toArray()));
        assertThat(expected, IsIterableContainingInOrder.contains(actual.toArray()));
    }
    @Test
    public void testShouldQueryAllConeObservableWithHeightRangeSpecification() {
        /*Given*/
        Specification<ConeObservable> specification = new SpecificationByHeightRange(3.0, 5.0);
        List<ConeObservable> expected = Arrays.asList(data.get(4),data.get(6));
        /*When*/
        List<ConeObservable> actual = repository.query(specification);
        /*Then*/
        Assert.assertNotNull(actual);
        assertThat(actual, IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
        assertThat(expected, IsIterableContainingInAnyOrder.containsInAnyOrder(actual.toArray()));
    }
    @Test
    public void testShouldQueryAllConeObservableWithHeightRangeSpecificationOrderedByRadiusComparator() {
        /*Given*/
        Comparator<ConeObservable> comparator = new RadiusComparator();
        Specification<ConeObservable> specification = new SpecificationByHeightRange(3.0, 5.0);
        List<ConeObservable> expected = Arrays.asList(data.get(6),data.get(4));
        /*When*/
        List<ConeObservable> actual = repository.query(specification, comparator);
        /*Then*/
        Assert.assertNotNull(actual);
        assertThat(actual, IsIterableContainingInOrder.contains(expected.toArray()));
        assertThat(expected, IsIterableContainingInOrder.contains(actual.toArray()));
    }
    @Test
    public void testShouldQueryAllConeObservableWithRadiusRangeSpecification() {
        /*Given*/
        Specification<ConeObservable> specification = new SpecificationByRadiusRange(1.3, 1.8);
        List<ConeObservable> expected = Arrays.asList(data.get(2),data.get(5), data.get(8));
        /*When*/
        List<ConeObservable> actual = repository.query(specification);
        /*Then*/
        Assert.assertNotNull(actual);
        assertThat(actual, IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
        assertThat(expected, IsIterableContainingInAnyOrder.containsInAnyOrder(actual.toArray()));
    }
    @Test
    public void testShouldQueryAllConeObservableWithRadiusRangeSpecificationOrderedByVolumeComparator() {
        /*Given*/
        Comparator<ConeObservable> comparator = new VolumeComparator(calculator);
        Specification<ConeObservable> specification = new SpecificationByRadiusRange(1.3, 1.8);
        List<ConeObservable> expected = Arrays.asList(data.get(5),data.get(2), data.get(8));
        /*When*/
        List<ConeObservable> actual = repository.query(specification, comparator);
        /*Then*/
        Assert.assertNotNull(actual);
        assertThat(actual, IsIterableContainingInOrder.contains(expected.toArray()));
        assertThat(expected, IsIterableContainingInOrder.contains(actual.toArray()));
    }
    @Test
    public void testShouldQueryAllConeObservableWithRadiusRangeSpecificationOrderedByXComparator() {
        /*Given*/
        Comparator<ConeObservable> comparator = new XComparator();
        Specification<ConeObservable> specification = new SpecificationByRadiusRange(1.3, 1.8);
        List<ConeObservable> expected = Arrays.asList(data.get(5),data.get(2), data.get(8));
        /*When*/
        List<ConeObservable> actual = repository.query(specification, comparator);
        /*Then*/
        Assert.assertNotNull(actual);
        assertThat(actual, IsIterableContainingInOrder.contains(expected.toArray()));
        assertThat(expected, IsIterableContainingInOrder.contains(actual.toArray()));
    }
    @Test
    public void testShouldQueryAllConeObservableWithIdSpecification() {
        /*Given*/
        Specification<ConeObservable> specification = new SpecificationById(6);
        List<ConeObservable> expected = Arrays.asList(data.get(5));
        /*When*/
        List<ConeObservable> actual = repository.query(specification);
        /*Then*/
        Assert.assertNotNull(actual);
        assertThat(actual, IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
        assertThat(expected, IsIterableContainingInAnyOrder.containsInAnyOrder(actual.toArray()));
    }
    @Test
    public void testShouldQueryAllConeObservableWithCentreSpecification() {
        /*Given*/
        Point centre = new Point(-2.4, 4.8, 2.1);
        Specification<ConeObservable> specification = new SpecificationByCentre(centre);
        List<ConeObservable> expected = Arrays.asList(data.get(1));
        /*When*/
        List<ConeObservable> actual = repository.query(specification);
        /*Then*/
        Assert.assertNotNull(actual);
        assertThat(actual, IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
        assertThat(expected, IsIterableContainingInAnyOrder.containsInAnyOrder(actual.toArray()));
    }
    @Test
    public void testShouldQueryAllConeObservableWithAreaSpecification() {
        /*Given*/
        Specification<ConeObservable> specification = new SpecificationByAreaRange(70.0, 90.0, calculator);
        List<ConeObservable> expected = Arrays.asList(data.get(1), data.get(3));
        /*When*/
        List<ConeObservable> actual = repository.query(specification);
        /*Then*/
        Assert.assertNotNull(actual);
        assertThat(actual, IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
        assertThat(expected, IsIterableContainingInAnyOrder.containsInAnyOrder(actual.toArray()));
    }
    @Test
    public void testShouldQueryAllConeObservableWithAreaSpecificationOrderedByYComparator() {
        /*Given*/
        Comparator<ConeObservable> comparator = new YComparator();
        Specification<ConeObservable> specification = new SpecificationByAreaRange(70.0, 90.0, calculator);
        List<ConeObservable> expected = Arrays.asList(data.get(3), data.get(1));
        /*When*/
        List<ConeObservable> actual = repository.query(specification, comparator);
        /*Then*/
        Assert.assertNotNull(actual);
        assertThat(actual, IsIterableContainingInOrder.contains(expected.toArray()));
        assertThat(expected, IsIterableContainingInOrder.contains(actual.toArray()));
    }
    @Test
    public void testShouldQueryAllConeObservableWithVolumeSpecification() {
        /*Given*/
        Specification<ConeObservable> specification = new SpecificationByVolumeRange(50.0, 70.0, calculator);
        List<ConeObservable> expected = Arrays.asList(data.get(3), data.get(4));
        /*When*/
        List<ConeObservable> actual = repository.query(specification);
        /*Then*/
        Assert.assertNotNull(actual);
        assertThat(actual, IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
        assertThat(expected, IsIterableContainingInAnyOrder.containsInAnyOrder(actual.toArray()));
    }
    @Test
    public void testShouldQueryAllConeObservableWithVolumeSpecificationOrderedByZComparator() {
        /*Given*/
        Comparator<ConeObservable> comparator = new ZComparator();
        Specification<ConeObservable> specification = new SpecificationByVolumeRange(50.0, 70.0, calculator);
        List<ConeObservable> expected = Arrays.asList(data.get(4), data.get(3));
        /*When*/
        List<ConeObservable> actual = repository.query(specification, comparator);
        /*Then*/
        Assert.assertNotNull(actual);
        assertThat(actual, IsIterableContainingInOrder.contains(expected.toArray()));
        assertThat(expected, IsIterableContainingInOrder.contains(actual.toArray()));
    }
}
