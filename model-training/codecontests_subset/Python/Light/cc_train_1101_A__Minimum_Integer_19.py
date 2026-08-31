n = int(input())

for i in range(n):
    l,r,d = map(int, input().strip().split())
    if d < l:
        print(d)
    else:
        print((r // d + 1) * d)