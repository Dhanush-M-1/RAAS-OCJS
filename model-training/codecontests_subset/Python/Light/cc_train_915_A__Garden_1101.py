n,k=map(int,input().split())
a=list(map(int,input().split()))
r=0
a.sort(reverse=True)
for i in a:
    if k%i==0:
        r=k//i
        break
print(r)
            
        