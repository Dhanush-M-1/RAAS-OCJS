

T = int(input())

for loop in range(T):

    n = int(input())

    pc = []

    for i in range(n):

        p,c = map(int,input().split())
        pc.append([p,c])

    flag = True

    for i in range(n):

        if i == 0:
            p,c = pc[i]
        else:
            p = pc[i][0] - pc[i-1][0]
            c = pc[i][1] - pc[i-1][1]

        if p < 0 or c < 0 or p < c:
            flag = False
            break

    if flag:
        print ("YES")
    else:
        print ("NO")
            
