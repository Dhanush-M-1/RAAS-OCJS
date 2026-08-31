t=int(input())
for i in range(0,t):
    li=[]
    n=int(input())
    a=[int(x) for x in input().split()]
    if a[0]==-1 and a[1]!=-1:
        li.append(a[1])
    for j in range(1,n-1):
        if a[j]==-1:
            if a[j-1]!=-1:
                li.append(a[j-1])
            if a[j+1]!=-1:
                li.append(a[j+1])
    if a[-1]==-1 and a[-2]!=-1:
        li.append(a[-2])
    # print(li)
    if li==[]:
        mx=0
        mn=0
    else:
        mn=min(li)
        mx=max(li)
    value=(mn+mx)//2
    for j in range(0,n):
        if a[j]==-1:
            a[j]=value
    # print(a)
    maxdiff=0
    maxdiff=max(maxdiff,abs(a[0]-a[1]))
    maxdiff=max(maxdiff,abs(a[-1]-a[-2]))
    for j in range(1,n-1):
        maxdiff=max(maxdiff,abs(a[j]-a[j-1]))
    print(maxdiff,value)