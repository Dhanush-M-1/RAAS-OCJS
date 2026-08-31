a,b=map(int,input().split())
k=0
while a>0:
    k+=1
    a-=1
    if k%b==0:
        a+=1
print(k)