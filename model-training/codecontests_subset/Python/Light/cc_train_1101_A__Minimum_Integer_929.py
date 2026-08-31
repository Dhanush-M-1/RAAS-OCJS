q = int(input())
for i in range(q):
    l, r, d = map(int, input().split())
    if l > d:
        print(d)
    elif r % d == 0:
        print(r + d)
    else:
        print(r // d * d + d)