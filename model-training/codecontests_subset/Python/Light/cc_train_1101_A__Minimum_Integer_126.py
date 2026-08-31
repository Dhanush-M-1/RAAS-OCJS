q = int(input())
for i in range(q):
    l, r, d = map(int, input().split())
    if l / d <= 1:
        n = 0
    else:
        n = 1
    m = r // d + 1
    if n == 0:
        x = d * m
    else:
        x = d * n
    print(x)
