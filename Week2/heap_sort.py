def swap(sqc, i, j):
    sqc[i], sqc[j] = sqc[j], sqc[i]


def heapify(sqc, end, i):
    l = 2 * i + 1
    r = 2 * (i + 1)
    max = i
    if l < end and sqc[i] < sqc[l]:
        max = l
    if r < end and sqc[max] < sqc[r]:
        max = r
    if max != i:
        swap(sqc, i, max)
        heapify(sqc, end, max)


def heap_sort(sqc):
    end = len(sqc)
    start = end / 2 - 1
    for i in range(start, -1, -1):
        heapify(sqc, end, i)
    for i in range(end-1, 0, -1):
        swap(sqc, i, 0)
        heapify(sqc, i, 0)


def main():
    sqc = [2, 7, 1, -2, 56, 5, 3]
    heap_sort(sqc)
    print(sqc)

if __name__ == '__main__':
    main()
