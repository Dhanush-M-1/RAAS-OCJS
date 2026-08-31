n=int(input())
l=[]
for i in range(n):
    l.append(list(map(int,input().split())))
l.sort()
if(n<2):
    print(1)
else:
    c=2
    for i in range(1,n-1):
        x=l[i][0]+l[i][1]
        y=l[i][0]-l[i][1]
        if(y>l[i-1][0]):
            c=c+1
        elif(x<l[i+1][0]):
            c=c+1
            l[i][0]=x
    print(c)