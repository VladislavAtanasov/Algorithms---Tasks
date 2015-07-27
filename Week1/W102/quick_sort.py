def swap(nums, i, j):
    temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp


def partitions(nums, first, last):
    pivot = nums[first]
    opened = first + 1
    closed = first
    for x in range(first + 1, last):
        if nums[x] < pivot:
            swap(nums, x, opened)
            closed = opened
            opened += 1
        else:
            continue
    swap(nums, first, closed)
    return closed


def sort_lists(nums, begin, end):
    if end - begin <= 1:
        return
    pivotIndex = partitions(nums, begin, end)
    sort_lists(nums, begin, pivotIndex)
    sort_lists(nums, pivotIndex + 1, end)
    return nums


def quick_sort(nums):
    new_numbers = list(nums)
    return sort_lists(new_numbers, 0, len(new_numbers))


def main():
    arr = [3, 2, 4, 13, 5, 33, 41, 4, 22, 42]
    print(quick_sort(arr))


if __name__ == '__main__':
    main()
