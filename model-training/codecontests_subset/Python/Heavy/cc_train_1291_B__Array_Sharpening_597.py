q = int(input())
for _ in range(q):
    n = int(input())
    c = [int(x) for x in input().split(' ')]
    if n == 1:
        print('YES')
    elif n == 2:
        if c[0] > 0 or c[1] > 0:
            print('YES')
        else:
            print('NO')
    else:
        if n%2 == 1:
            f = 0
            d = [x for x in range(n//2)]
            d = d + [(n-1)//2] + d[::-1]
            #print(d)
            for i in range(n):
                if c[i] < d[i]:
                    f = 1
                    break
            if f == 0:
                print('YES')
            else:
                print('NO')
        else:
            f = 0
            d = [x for x in range(n//2)]
            d = d + d[::-1]
            #print(d)
            for i in range(n):
                if c[i] < d[i]:
                    f = 1
                    break
            if (f == 0) and (c[n//2-1] >= n//2 or c[n//2] >= n//2):
                print('YES')
            else:
                print('NO')

