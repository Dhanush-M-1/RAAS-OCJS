T = int(input())
for cas in range(T):
    l, r, d = map(int, input().split())
    if l > d:
        print(d)
    else:
        print(r // d * d + d)
