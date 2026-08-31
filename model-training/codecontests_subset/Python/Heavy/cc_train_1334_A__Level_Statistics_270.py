from sys import stdin,stdout
t=int(input())
for  i in range(t):
    n=int(input())
    l=[]
    ans="YES"
    for j in range(n):
        l1=list(map(int,stdin.readline().split()))
        l.append(l1)
        if l1[1]>l1[0]:
            ans="NO"
    
    if n!=1:
        for j in range(1,n):
            if l[j][0]-l[j-1][0]<l[j][1]-l[j-1][1]:
                ans="NO"
            if l[j][1]<l[j-1][1]:
                ans="NO"
            if l[j][0]<l[j-1][0]:
                ans="NO"
    else:
        if l[0][1]>l[0][0]:
            ans="NO"
    print(ans)
