for _ in range(int(input())):
    n=int(input())
    ar=[]
    for i in range(n):
        ar.append(list(input()))
    st=[int(ar[0][1]),int(ar[1][0])]
    fi=[int(ar[n-1][n-2]),int(ar[n-2][n-1])]
    ans=[]
    if(st[0]!=st[1] and fi[0]!=fi[1]):
        if(st[0]!=0):
            ans.append([1,2])
        if(st[1]!=0):
            ans.append([2,1])
        if(fi[0]!=1):
            ans.append([n,n-1])
        if(fi[1]!=1):
            ans.append([n-1,n])
    elif(st[0]==st[1]):
        ty=abs(st[0]-1)
        if(fi[0]!=ty):
            ans.append([n,n-1])
        if(fi[1]!=ty):
            ans.append([n-1,n])
    elif(fi[0]==fi[1]):
        ty=abs(fi[0]-1)
        if(st[0]!=ty):
            ans.append([1,2])
        if(st[1]!=ty):
            ans.append([2,1])
    print(len(ans))
    for i in ans:
        print(*i)