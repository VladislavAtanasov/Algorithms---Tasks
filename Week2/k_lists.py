class KLists:

    # Merge K sorted lists.
    # lists - [Node]
    def merge(self, lists):
        temp = []
        result = []
        for lis in lists:
            if len(lis) == 0:
                pass
            else:
                temp.append(lis[0])
        result.append(min(temp))
        print(min(temp))
        for x in lists:
            if len(x) == 0:
                pass
            elif len(result) == len(temp):
                return result
            elif x[0] == min(temp):
                x.pop(0)
        temp = []
        self.merge(lists)


def main():
    arr = [3, 2, 4, 13, 5, 33, 41, 4, 22, 42]
    KL = KLists()
    print(KL.merge([[3, 5, 7, 9], [2, 4, 6], [0, 1, 8, 10]]))


if __name__ == '__main__':
    main()
