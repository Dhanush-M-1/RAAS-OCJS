t=int(input())
while t>0:
    n=int(input())
    l=[]
    f=0
    for i in range (0,n):
        l.append([int(j) for j in input().split()])
        i=0
    if (l[i][0] < l[i][1]):
        f = 1
    for i in range (n-1):
        if(l[i+1][0]-l[i][0]<0):
            f=1
        if(l[i][0]<l[i][1]):
            f=1
        if(l[i+1][0]-l[i][0]<l[i+1][1]-l[i][1]):
            f=1
        if(l[i+1][1]-l[i][1]<0):
            f=1
        #rint (f)
    i = n-1
    if (l[i][0] < l[i][1]):
        f = 1
    if(f==0):
        print("YES")
    else:
        print("NO")
    t=t-1