class PhoneBook:
    def lookup_names(self, phone_book, numbers):
        result = []
        for x in range(0, len(phone_book)):
            if phone_book[x][0] in numbers:
                result.append(phone_book[x][1])
        return result


def main():
    phone = PhoneBook()
    print(phone.lookup_names([(1, "Stanislav"), (15, "Rado"), (6, "Ivan"), (8, "Ivan")], [15, 8]))


if __name__ == '__main__':
    main()
