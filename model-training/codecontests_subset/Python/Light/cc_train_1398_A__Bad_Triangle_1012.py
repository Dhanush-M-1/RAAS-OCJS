n = int(input())
for i in range(n):
    m = int(input())
    s = input().split(' ')
    a = []
    for c in s:
        a.append(int(c))
    a.sort()
    if a[len(a) - 1] >= (a[0] + a[1]):
        print(1, 2, len(a))
    else:
        print(-1)
