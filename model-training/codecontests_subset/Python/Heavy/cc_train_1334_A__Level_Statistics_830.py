T = int(input())

for i in range(T):
    flag = 0
    n = int(input())
    p = []
    c = []

    for j in range(n):
        x,y = list(map(int,input().split()))
        p.append(x)
        c.append(y)

    if(p[0] < c[0]):
        print("NO")
        continue

    for j in range(1,n):

        if p[j] < p[j - 1]:
            print("NO")
            flag = 1
            break

        elif c[j] < c[j - 1]:
            print("NO")
            flag = 1
            break

        elif p[j] - p[j-1] < c[j] - c[j-1]:
            print("NO")
            flag = 1
            break

    if flag == 0:
        print("YES")

