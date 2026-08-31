n=int(input())
x=[]
h=[]
if n==1:
    print(1)
else:
    for _ in range(n):
        a,b=map(int,input().split())
        x.append(a)
        h.append(b)
    count=2
    l=x[0]+1
    for j in range(1,n-1):
        h1=h[j]
        if (x[j]-l)>=h1:
            count+=1
            l=x[j]+1
        elif (x[j+1]-x[j]-1)>=h1:
            count+=1
            l=x[j]+h1+1
        else:
            l=x[j]+1
    print(count)
    