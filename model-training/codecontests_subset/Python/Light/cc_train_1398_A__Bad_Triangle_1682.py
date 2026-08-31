t = int(input())
for _ in range(t):
    n = int(input())
    l = list([int(x) for x in input().split()])
    a = l[0]
    b = l[1]
    c = l[n-1]
    if(a+b <= c):
        print(1, 2, n)
    else:
        print('-1')