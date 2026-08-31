T = int(input())

for _ in range(T):
    length = int(input())
    a = list(map(int, input().split()))
    
    x = a[0]
    y = a[1]
    z = a[-1]

    if (x+y <= z):
        print(1, 2, len(a))
    else:
        print(-1)