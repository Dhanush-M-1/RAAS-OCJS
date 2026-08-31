def main():
    t = int(input())
    for _ in range(t):
        n = int(input())
        if n == 1:
            print(0)
        else:
            i = 0
            while n != 1:
                if n % 3 != 0:
                    print(-1)
                    break
                elif n % 6 == 0:
                    n = n // 6
                    i += 1
                else:
                    n = n // 3
                    i += 2
            else:
                print(i)


if __name__ == '__main__':
    main()
