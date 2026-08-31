q = int(input())

for _ in range(q):
    l, r, d = map(int, input().split())
    if l / d > 1:
        print(d)
    else:
        print(d * (r // d + 1))