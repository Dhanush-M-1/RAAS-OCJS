t=int(input())
for _ in range(t):
    m,n = [int(x) for x in input().split()]
    a = [int(x) for x in input().split()]
    b = [int(x) for x in input().split()]
    h=[]
    for _ in range(1001):
        h.append(0)
    for i in a:
        h[i]+=1
    min = -1
    for i in range(n):
        if h[b[i]] != 0 :
            if min == -1:
                min = b[i]
            elif b[i]<min:
                min = b[i]
    if min==-1:
        print('NO')
    else:
        print('YES')
        print(1,min)
