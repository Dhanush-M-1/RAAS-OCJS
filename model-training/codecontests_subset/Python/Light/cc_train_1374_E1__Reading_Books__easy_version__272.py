n,k = map(int,input().split())
alice = []
bob=[]
comm=[]
for _ in range(n):
    a,b,c=map(int,input().split())
    if(b==1 and c==1):
        comm.append(a)
    elif(b==1 and c==0):
        alice.append(a)
    elif(b==0 and c==1):
        bob.append(a)
alice.sort()
bob.sort()
for i in range(min(len(alice),len(bob))):
    comm.append(alice[i]+bob[i])
comm.sort()
if(len(comm) < k):
    print(-1)
else:
    print(sum(comm[:k]))
        