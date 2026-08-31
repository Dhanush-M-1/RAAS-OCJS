n,k=tuple(map(int,input().split()))
a=[int(x) for x in input().split()]; a1=[]
for b in a:
    if k%b==0:
        a1.append(b)
        
print(k//max(a1))
