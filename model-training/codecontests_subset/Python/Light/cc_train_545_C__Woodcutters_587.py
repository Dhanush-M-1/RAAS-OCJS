n=int(input())
l=[]
m=[]
c=2
if(n==1):
    print('1')
    exit()
for _ in range(n):
    a,b=map(int,input().split())
    l.append(a)
    m.append(b)
for i in range(1,n-1):
    if(m[i]<abs(l[i]-l[i-1])):
        c=c+1
    elif(m[i]<abs(l[i]-l[i+1])):
        c=c+1
        l[i]+=m[i]
        
print(c)