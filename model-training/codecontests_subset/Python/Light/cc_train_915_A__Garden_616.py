n,k=input().split()
n,k=int(n),int(k)
l=list(map(int,input().split()))
l.sort()
for i in range(len(l)-1,-1,-1):
    if k%l[i]==0:
        print(k//l[i])
        break
    
