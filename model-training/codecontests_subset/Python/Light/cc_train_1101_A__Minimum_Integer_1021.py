q = int(input())

for i in range(q):
    l, r, x = map(int, input().split())
    if (l > x or x > r):
        print(x)
    
    else:
        print((r // x) * x + x)