n,k=map(int, input().split())
tab=[tuple(map(int,input().split())) for _ in range(n)]
both=[tabi[0] for tabi in tab if tabi[1:]==(1,1)]
both.sort()

alice=[tabi[0] for tabi in tab if tabi[1:]==(1,0)]# tabi[1]==1 and tabi[2]==0]
bob=[tabi[0] for tabi in tab if tabi[1:]==(0,1)]
alice.sort()
bob.sort()

ab=[alice[i]+bob[i] for i in range(min(len(alice),len(bob)))]

both+=ab
both.sort()
if len(both)<k:
    print(-1)
else:print(sum(both[:k]))
