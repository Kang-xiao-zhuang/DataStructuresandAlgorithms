接口设计

```java
int size();// 元素的数量

boolean isEmpty();// 是否为空

boolean contains(E element); // 是否包含某个元素

void add(E element); // 添加元素到最后面

E get( int index); // 返回 index 位置对应的元素

E set( int index , E element); // 设置 index 位置的元素

void add( int index , E element); // 往index 位置添加元素

E remove( int index); // 删除 index 位置对应的元素

int indexOf(E element); // 查看元素的位置

void clear();// 清除所有元素
```

重要代码实现

```java
	public void add(int index, E element) {
        rangeCheckForAdd(index);

        ensureCapacity(size + 1);

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    public E remove(int index) {
        rangeCheck(index);

        E old = elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        elements[--size] = null;
        return old;
    }

    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) return i; // n
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        // 新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;

        System.out.println(oldCapacity + "扩容为" + newCapacity);
    }

    private void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }
```

