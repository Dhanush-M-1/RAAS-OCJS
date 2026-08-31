t = int(input())
for test_case in range(t):
    n = [int(x) for x in input().split()]
    n = n[0]

    res = 0

    if n == 1:
        print()
        print(res)
        print()
    else:
        while True:
            if n % 3 == 0:
                if n % 2 == 0:
                    res += 1
                    n /= 6
                else:
                    res += 1
                    n *= 2
            elif n == 1:
                print()
                print(res)
                print()
                break
            else:
                print()
                print(-1)
                print()
                break