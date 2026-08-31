try:
    t = int(input())
    for j in range(t):
        p = list(map(int, input().rstrip().split()))
        r = n = p[0]
        k = False
        count = 0
        if n == 1:
            print(0)
            continue
        while n != 1:
            if n % 6 == 0:
                n = n / 6
                k = True
                count += 1
            elif n % 3 == 0:
                n *= 2
                count += 1
            else:
                k = False
                break
        if k:
            print(count)
        else:
            print(-1)
except:
    pass
