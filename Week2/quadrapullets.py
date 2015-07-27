def zero_quadruplets_count(a, b, c, d):
    sums = []
    for x in a:
        for y in b:
            sums.append(x + y)
    count = 0
    for u in c:
        for z in d:
            if -(u + z) in sums:
                count += 1
    return count


def main():
    arr = [5, 3, 4]
    brr = [-2, -1, 6]
    crr = [-1, -2, 4]
    drr = [-1, -2, 7]
    print(zero_quadruplets_count(arr, brr, crr, drr))


if __name__ == '__main__':
    main()
