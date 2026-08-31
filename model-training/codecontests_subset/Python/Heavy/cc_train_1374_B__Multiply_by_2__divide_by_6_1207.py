def main():
    t = int(input())
    for _ in range(t):
        n = int(input())
        if n == 1:
            print(0)
        elif n % 3 != 0:
            print(-1)
        else:
            c2, c3 = 0, 0
            while n % 2 == 0:
                n //= 2
                c2 += 1
            while n % 3 == 0:
                n //= 3
                c3 += 1
            if n != 1 or c2 > c3:
                print(-1)
            else:
                if c2 == c3:
                    print(c3)
                else:
                    print(2 * c3 - c2)


if __name__ == '__main__':
    main()
