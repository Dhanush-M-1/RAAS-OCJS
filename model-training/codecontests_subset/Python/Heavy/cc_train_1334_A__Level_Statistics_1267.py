import sys
t=int(sys.stdin.readline())
for _ in range(t):
    a=[]
    k = int(sys.stdin.readline())
    flag = True
    for i in range(k):
        x,y=map(int,input().split())
        a.append([x,y])
    if(a[0][0]<a[0][1]):
        flag=False
    for i in range(0,k-1):
        if(a[i+1][0]-a[i][0])<0:
            flag=False
        if(a[i+1][1]-a[i][1])<0:
            flag=False
        if((a[i+1][0]-a[i][0])-(a[i+1][1]-a[i][1]))<0:
            flag=False
    if(flag==True):
        print("YES")
    else:
        print("NO")

