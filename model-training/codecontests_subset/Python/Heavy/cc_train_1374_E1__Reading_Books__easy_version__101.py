
n,kk = map(int,input().split())
alice = []
bob = []
both =[]
for i in range(n):
    t,a,b = map(int,input().split())
    if a==1 and b==1:
        both.append(t)
    elif a==1:
        alice.append(t)
    elif b==1:
        bob.append(t)
alice.sort()
bob.sort()
both.sort()
count=0
l = min(len(alice),len(bob))
i=0
j=0
k=0
ans=0
if len(both)+len(bob)<kk or len(alice)+len(both)<kk:
    print(-1)
else:
    while j<l and count<kk:
        if k>=len(both) or alice[j]+bob[j] < both[k]:
            ans+=alice[j]+bob[j]
            j+=1
            count+=1
        else:
            ans+=both[k]
            k+=1
            count+=1
    print(ans+sum(both[k:k+kk-count]))

