from sys import*
input= stdin.readline
for _ in range(1):
    n,k=map(int,input().split())
    c=[]
    a=[]
    b=[]
    for _ in range(n):
        x,y,z=map(int,input().split())
        if(y==1 and z==1):
            c.append(x)
        elif(y==1):
            a.append(x)
        elif(z==1):
            b.append(x)
    a.sort()
    b.sort()
    for i in range(min(len(a),len(b))):
        c.append(a[i]+b[i])
    c.sort()
    if(len(c)>=k):
        print(sum(c[:k]))
    else:
        print(-1)
        

                
            