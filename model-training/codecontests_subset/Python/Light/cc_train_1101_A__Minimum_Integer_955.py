q = int(input())
for i in range(q):
    ls = list(map(int, input().split()))
    l = ls[0]
    r = ls[1]
    d = ls[2]
    if d < l:
        print(d)
    else:
        print((r // d + 1) * d)
