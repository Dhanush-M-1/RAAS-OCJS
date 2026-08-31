n,k=map(int,input().split())
kl=list(map(int,input().split()))
kl.sort()
for x in range(len(kl)-1,-1,-1):
    if k%kl[x]==0:print(int(k/kl[x]));break



    
