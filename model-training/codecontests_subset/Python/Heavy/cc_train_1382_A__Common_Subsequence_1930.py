t = int(input())
o = []
for each in range(t):
    n, m = input().split()
    n, m = int(n), int(m)
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    c = 0
    for i in range(n):
        for j in range(m):
            if a[i] == b[j]:
                c = a[i]
                break
        if c > 0:
            break
    if c > 0:
        o.append(['YES', [1, c]])
    else:
        o.append(['NO'])
for i in o:
    if len(i) == 2:
        print(i[0])
        print(*i[1])
    else:
        print(i[0])