n,k=map(int,input().split())
l=[]
common=[]
alice=[]
bob=[]
for i in range(0,n):
    t,a,b=map(int,input().split())
    if(a&b):
        common.append(t)
    elif(a):
        alice.append(t)
    elif(b):
        bob.append(t)
if(len(alice)+len(common)<k or len(bob)+len(common)<k):
    print(-1)
else:
    common.sort()
    alice.sort()
    bob.sort()
    for i in range(0,min(len(alice),len(bob))):
        common.append(alice[i]+bob[i])
    common.sort()
    if(len(common)>=k):
        print(sum(common[0:k]))
    else:
        print(-1)