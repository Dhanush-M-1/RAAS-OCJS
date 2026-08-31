n = int(input())

for _ in range(n):
    l, r, d = map(int, input().split())
    flag = False
    if d < l:
        print(d)
        continue
    if d > r:
        print(d)
        continue
    print(r // d * d + d)