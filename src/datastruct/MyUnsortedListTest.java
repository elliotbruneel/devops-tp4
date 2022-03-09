package datastruct;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyUnsortedListTest {

    UnsortedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = MyUnsortedList.of();
    }

    @Test
    void testListIsEmpty() {
        assertTrue(list.isEmpty());
    }

    @Test
    void testListIsNotEmpty() {
        list.append(1);
        assertFalse(list.isEmpty());
    }

    @Test
    void testListSize() {
        assertEquals(0, list.size());
        list.append(1);
        assertEquals(1, list.size());
        list.append(2);
        assertEquals(2, list.size());
    }

    @Test
    void testListSizeOnEmptyList() {
        assertEquals(0, list.size());
    }

    @Test
    void testListAppend() {
        list.append(1);
        list.append(2);
        list.append(3);
        assertEquals(3, list.size());
    }

    @Test
    void testPop() {
        list.append(1);
        list.append(2);
        list.append(3);
        assertEquals(1, list.pop());
        assertEquals(2, list.pop());
        assertEquals(3, list.pop());
        assertEquals(0, list.size());
    }

    @Test
    void testPopOnEmptyList() {
        assertThrows(EmptyListException.class, () -> list.pop());
    }

    @Test
    void testListRemove() {
        list.append(1);
        list.append(2);
        list.append(3);
        list.remove(2);
        assertEquals(2, list.size());
    }

    @Test
    void testListRemoveNotExist() {
        list.append(1);
        list.append(2);
        list.append(3);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(4));
    }

    @Test
    void testRemoveIndexZero() {
        list.append(1);
        list.append(2);
        list.append(3);
        list.remove(0);
        assertEquals(2, list.size());
    }

    @Test
    void testEquals() {
        list.append(1);
        list.append(2);
        list.append(3);
        UnsortedList<Integer> list2 = MyUnsortedList.of();
        list2.append(1);
        list2.append(2);
        list2.append(3);
        assertEquals(list, list2);
    }

    @Test
    void testNotEquals() {
        list.append(1);
        list.append(2);
        list.append(3);
        UnsortedList<Integer> list2 = MyUnsortedList.of();
        list2.append(1);
        list2.append(2);
        list2.append(4);
        assertNotEquals(list, list2);
    }

    @Test
    void testPopLast() {
        list.append(1);
        list.append(2);
        list.append(3);
        assertEquals(3, list.popLast());
    }

    @Test
    void testPopLastOnEmptyList() {
        assertThrows(EmptyListException.class, () -> list.popLast());
    }

    @Test
    void testToString() {
        list.append(1);
        list.append(2);
        list.append(3);
        assertEquals("MyUnsortedList { size = 3, [1, 2, 3] }", list.toString());
    }

    @Test
    void testInsertNegativePosition() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(0, -1));
    }

    @Test
    void testItInsertsElementAtTheEnd() {
        list.append(1);
        list.append(2);
        list.append(3);
        list.insert(3, 3);
        assertEquals(4, list.size());
        assertEquals(3, list.popLast());
    }

    @Test
    void testItInsertsElementInTheMiddle() {
        list.append(1);
        list.append(2);
        list.append(3);
        list.insert(2, 2);
        assertEquals(4, list.size());
        assertEquals(3, list.popLast());
    }

    @Test
    void testItInsertsElementAtTheBeginning() {
        list.append(1);
        list.append(2);
        list.append(3);
        list.insert(0, 0);
        assertEquals(4, list.size());
        assertEquals(3, list.popLast());
    }

    @Test
    void testItInsertsElementAtTheEndWithEmptyList() {
        list.insert(0, 0);
        assertEquals(1, list.size());
        assertEquals(0, list.popLast());
    }

    @Test
    void testItInsertAndRemoveElementAtTheEnd() {
        list.append(1);
        list.append(2);
        list.append(3);
        list.insert(3, 3);
        list.remove(3);
        assertEquals(3, list.size());
        assertEquals(3, list.popLast());
    }

    @Test
    void testItInsertAndRemoveElementInTheMiddle() {
        list.append(1);
        list.append(2);
        list.append(3);
        list.insert(2, 2);
        list.remove(2);
        assertEquals(3, list.size());
        assertEquals(3, list.popLast());
    }

    @Test
    void testInsertAnything() {
        list.insert(0,0);
        list.insert(1, 0);
        list.insert(2, 0);
        list.remove(0);
        list.remove(0);
        assertEquals(1, list.size());
    }

    @Test
    void testItRemoveOnEmptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    void testItCreateWithDefaultValues() {
        UnsortedList<Integer> list = MyUnsortedList.of(1,2,3);
        assertEquals(3, list.size());
    }

    @Test
    void testItNotEqualsWhenClassAreDifferent() {
        assertNotEquals(list, new Object());
    }

    @Test
    void testItNotEqualsWhenSizerAreDifferent(){
        UnsortedList<Integer> list2 = MyUnsortedList.of();
        list2.append(1);
        assertNotEquals(list, list2);
    }
}
