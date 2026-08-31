def main() :
    t = int(input())
    s = input()
    if len(s) == 1 :
        print(1)
        print(s)
        return
    else :
        z = 0
        one = 0
        for i in s :
            if i == "0" :
                z += 1
            elif i == "1" :
                one += 1
        if z == one :
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
        elif z != one :
            print(1)
            print(s)
            return
if __name__ == "__main__" :
    main()