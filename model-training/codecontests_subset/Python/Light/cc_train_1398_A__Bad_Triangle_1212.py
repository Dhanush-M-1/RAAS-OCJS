for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    
    if a[0] + a[1] <= a[n-1]:
        print("{} {} {}".format(1, 2, n))
        continue
    else:
        print(-1)