
class BirthdayRanges:
    def birthdays_count(self, birthdays, ranges):
        count = 0
        result = []
        for x in range(0, len(ranges)):
            for elem in birthdays:
                if elem <= ranges[x][1] and elem >= ranges[x][0]:
                    count += 1
            result.append(count)
            count = 0
        return result


def main():
    bir = BirthdayRanges()
    print(bir.birthdays_count([5, 10, 6, 7, 3, 4, 5, 11, 21, 300, 15], [(4, 9), (6, 7), (200, 225), (300, 365)]))

if __name__ == '__main__':
    main()
