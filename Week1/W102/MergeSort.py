class MergeSort:
    def __init__(self):
        pass

    def merge(self, l, r):
        result = []
        while len(l) != 0 and len(r) != 0:
            if l[0] <= r[0]:
                result.append(l[0])
                l = l[1:]
            else:
                result.append(r[0])
                r = r[1:]
        while len(l) != 0:
            result.append(l[0])
            l = l[1:]
        while len(r) != 0:
            result.append(r[0])
            r = r[1:]
        return result

    def mer_sort(self, arr):
        if len(arr) <= 1:
            return arr
        left = []
        right = []
        middle = len(arr) / 2
        for x in range(0, middle):
            left.append(arr[x])
        for x in range(middle, len(arr)):
            right.append(arr[x])
        left = self.mer_sort(left)
        right = self.mer_sort(right)
        return self.merge(left, right)


def main():
    mer = MergeSort()
    myarr = [2342, 2211, 2, 1, 0, 4, 331, 43, 21, 5, 10,45,354,5434,6,6,45,6,4,6,3,633,6,6,3,6,36,3,63,6,36,36,34,63,6,36,0,63,6,3]
    print(mer.mer_sort(myarr))


if __name__ == '__main__':
    main()
