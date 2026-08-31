n,k=map(int,input().split())
ai=list(map(int,input().split()))
b=0
for x in ai :
    if (k % x==0)and(x>b):
        b=x
        res=k//x
print(res)
        
