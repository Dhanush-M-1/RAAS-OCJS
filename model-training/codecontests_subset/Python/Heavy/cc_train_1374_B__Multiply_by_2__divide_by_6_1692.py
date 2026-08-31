def main():
    t = int(input())
    for case in range(t):
        n = int(input())
        res = n
        count = 0
        flag = True
        if res == 1:
            print(0)
        else:
            while flag:
                while res % 6 == 0:
                    res /= 6
                    count += 1
                if res % 3 != 0 and int(res) != 1:
                    count = -1
                    flag = False
                    break
                if res == 1:
                    flag = False
                    break
                res *= 2
                count += 1
                if res % 6 != 0:
                    if count == 1:
                        count = -1
                    flag = False
            print(count)


if __name__ == '__main__':
    main()
