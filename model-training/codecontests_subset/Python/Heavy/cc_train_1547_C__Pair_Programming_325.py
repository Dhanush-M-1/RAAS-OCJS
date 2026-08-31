t = int(input())
for i in range(0, t):
    c= input()
    k,n,m = map(int, input().split())
    lsta = list(map(int, input().split()))
    lstb = list(map(int, input().split()))
    a = 0
    b = 0
    out = []
    g = 0
    while(a<n or b<m):
        tempa = a
        tempb = b
        if(a<n and lsta[a]<=k):
            if(lsta[a]==0):
                k+=1
            out.append(lsta[a])
            a+=1
        elif(b<m and lstb[b]<=k):
            if(lstb[b]==0):
                k+=1
            out.append(lstb[b])
            b+=1
        if(a==tempa and b == tempb):
            g=1
            print(-1)
            break
    if(g==0):
        print(*out, end = " ")
        print()