t=int(input())
for i in range(t):
    n=int(input())
    b=[]
    flag=0
    for j in range(n):
        a=list(map(int,input().split()))
        b.append(a)
    for j in range(n):
        if b[j][0] < b[j][1]:
            flag=1
            break
        else:
            continue
    for j in range(n-1):
        if b[j][0] > b[j+1][0]:
            flag=1
            break
        else:
            continue
    for j in range(n-1):
        if b[j][1] > b[j+1][1]:
            flag=1
            break
        else:
            continue
    for j in range(n-1):
        if (b[j+1][0]-b[j][0]) < (b[j+1][1]-b[j][1]):
            flag=1
            break
        else:
            continue
    if flag == 1:
        print("NO")
    else:
        print("YES")
            
