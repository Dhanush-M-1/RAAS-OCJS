n = int(input())
a = []

for i in range(n):
    l, r, d = map(int, input().split())
    a.append([l, r, d])

for i in a:
    l, r, d = list(i)
    if d < l:
        print(d)
    else:
        c = r // d
        print((c + 1) * d)

