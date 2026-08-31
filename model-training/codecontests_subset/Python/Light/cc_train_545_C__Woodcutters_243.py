n = int(input())
coor = []
h = []
line = []
ans = 2
l = 0
r = 0
if n > 2:
    for i in range(n):
        k = input().split()
        line.append([int(k[0]), int(k[1])])
    for i in range(1, n-1):
        if line[i][0] - line[i][1] > line[i-1][0] + r:
            ans += 1
            r = 0
        elif line[i][0] + line[i][1] < line[i+1][0]:
            ans += 1
            r = line[i][1]
        else:
            r = 0
    print(ans)
else:
    print(n)
