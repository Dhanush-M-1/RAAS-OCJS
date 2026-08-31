tests = int(input())
for _ in range(tests):
    n = int(input())
    d = dict()
    d[n] = 1
    count = 0
    if n == 1:
        print(0)
        continue
    while n != 1:
        if n % 3 != 0:
            print(-1)
            break
        if n % 6 == 0:
            n //= 6
            if n in d:
                print(-1)
                break
            d[n] = 1
        else:
            n *= 2
            if n in d:
                print(-1)
                break
            d[n] = 1
        count += 1
    if n == 1:
        print(count)