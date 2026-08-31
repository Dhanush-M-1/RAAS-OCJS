t = int(input())
for _ in range(t):
    p = int(input())
    l = []
    for i in range(p):
        a, b = [int(x) for x in input().split()]
        l.append((a, b))
    flag = 0
    for i in range(len(l)):
        if l[i][0] < l[i][1]:
            flag = 1
            break
        if i != 0 and (l[i][0] < l[i - 1][0] or l[i][1] < l[i - 1][1]):
            flag = 1
            break
        if i != 0 and l[i][0] - l[i - 1][0] < l[i][1] - l[i - 1][1]:
            flag = 1
            break
    if flag == 1:
        print("NO")
    else:
        print("YES")
