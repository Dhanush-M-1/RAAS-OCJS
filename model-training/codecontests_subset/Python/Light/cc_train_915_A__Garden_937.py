n,k=map(int,input().split())
ai=list(map(int,input().split()))
b=0
for i in range(0,n):
    
    if k%ai[i] == 0 and ai[i]>b:
        b=ai[i]
print(k//b)

