q = int(input())
for i in range(q):
    l, r, d = map(int,input().split())
    u = d
    if u < l:
        print(u)
        continue
    u = r // d * d + d
    print(u)