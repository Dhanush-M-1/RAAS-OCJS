n=int(input())
a=[int(i) for i in input().split()]
b=sorted(a)
c=[]
c.append(a)
for i in range(1,n+1):
    k=len(c[i-1])-1-c[i-1][::-1].index(b[i-1])
    c.append(c[i-1][0:k]+c[i-1][k+1::]) 
m=int(input())
for i in range (m):
    k,pos=map(int,input().split())
    print (c[len(c)-k-1][pos-1])
    