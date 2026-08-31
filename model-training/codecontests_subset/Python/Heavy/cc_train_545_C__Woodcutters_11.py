n = int(input())
d = []

for i in range(n):
    d.append(list(map(int, input().split())))

if n == 1:
    print(1)
else:
    c = 2
    mgr = False
    for i in range(1, n-1):
        if mgr:
            if d[i][0]-d[i][1] > d[i-1][0]+d[i-1][1]:
                mgr = False
                c += 1
            else:
                if d[i][0]+d[i][1] < d[i+1][0]:
                    c += 1
                else:
                    mgr = False
        else:
            if d[i][0]-d[i][1] > d[i-1][0]:
                c += 1
            else:
                if d[i][0]+d[i][1] < d[i+1][0]:
                    c += 1
                    mgr = True

    print(c)