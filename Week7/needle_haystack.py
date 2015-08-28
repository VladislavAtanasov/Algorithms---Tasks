import hashlib


class NeedleHaystack:

    def findOccurence(self, targ, string):
        arr = []
        mystring = targ
        hash_object = hashlib.md5(mystring.encode())
        hashed = hash_object.hexdigest()
        for x in range(len(string) - 2):
            new = string[x] + string[x + 1] + string[x + 2]
            mystring = new
            hash_object = hashlib.md5(mystring.encode())
            hashednew = hash_object.hexdigest()
            if hashednew == hashed:
                arr.append(x)
        return arr

def main():
    string = input()
    target = input()
    nh = NeedleHaystack()
    result = nh.findOccurence(target, string)
    for x in result:
        print(x)

if __name__ == '__main__':
    main()
