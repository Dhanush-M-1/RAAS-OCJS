


a,b=map(int,input().split())

c=a
k=1
while(k!=0):
    k=a//b
    q=a-b*k
    a=k+q
    c=c+k
    if(k==0):
        break
print(c)
