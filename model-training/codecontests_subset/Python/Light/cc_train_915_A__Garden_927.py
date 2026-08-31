n,k=map(int,input().split())
kl=list(map(int,input().split()))
kl.sort()
for x in kl:
    if k%x==0:temp=x
print(int(k/temp))

    
