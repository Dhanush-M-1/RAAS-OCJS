n = int(input())
a = [int(s) for s in input().split(' ')]
if n > 3:
    print(1, 1)
    print(-a[0])
    print(2, n)
    lst = []
    for i in range(1, n):
        lst.append(str(a[i] * (n - 1)))
    print(' '.join(lst))
    print(1, n)
    lst2 = ['0'] + [str(-n * int(a) // (n - 1)) for a in lst]
    print(' '.join(lst2))
elif n == 2:
    print(1, 1)
    print(-a[0])
    print(2, 2)
    print(-a[1])
    print(1,2)
    print(0,0)
elif n == 1:
    print(1,1)
    print(-a[0])
    print(1,1)
    print(0)
    print(1,1)
    print(0)
elif n == 3:
    print(1, 1)
    print(-a[0])
    print(2, 2)
    print(-a[1])
    print(3,3)
    print(-a[2])

