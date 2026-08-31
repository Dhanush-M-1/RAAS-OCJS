a, b = [i for i in input().split()]
n = int(input())
r = [[a, b]]
for j in range(n):
    c, d = [z for z in input().split()]
    if c == a:
        a = d
    else:
        b = d
    r.append([a, b])
for elem in r:
    print(*elem)
