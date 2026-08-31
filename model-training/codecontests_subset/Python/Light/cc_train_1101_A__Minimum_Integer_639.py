n = int(input())
for i in range(n):
    l, r, d = map(int, input().split())
    if(l > d): print(d)
    else: print(d * (r//d + 1))