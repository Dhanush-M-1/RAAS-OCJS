n = int(input())
for _ in range(n):
        a = list(map(int,input().split()))
        l = a[0]
        r = a[1]
        d = a[2]
        if l<=d and d<=r:
                print((r//d+1)*d)
        else:
                print(d)