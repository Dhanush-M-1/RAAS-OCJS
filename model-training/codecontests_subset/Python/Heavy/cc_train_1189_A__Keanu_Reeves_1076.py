def main() :
    n = int(input())
    s = input()
    if len(s) == 1 :
        print(1)
        print(s)
        return
    else :
        zero = 0
        one = 0
        for i in s :
            if i == "0" :
                zero += 1
            elif i == "1" :
                one += 1
        if zero == one :
            print(2)
            start = s[0]
            if len(s) == 2 :
                print(s[0] + " " + s[1])
                return
            else :
                for j in range(1,len(s)) :
                    if s[j] != start :
                        print(s[:(j)] + " " + s[(j):])
                        return
        elif zero != one :
            print(1)
            print(s)
            return
if __name__ == "__main__" :
    main()