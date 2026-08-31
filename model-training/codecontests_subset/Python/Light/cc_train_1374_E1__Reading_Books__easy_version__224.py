import sys
input=sys.stdin.readline

n, k=map(int, input().split())

alice=[] #10
bob=[] #01
both=[] #11
for _ in range(n):
    r=list(map(int, input().split()))
    if r[1]==1 and r[2]==0: alice.append(r[0])
    elif r[1]==0 and r[2]==1: bob.append(r[0])
    elif r[1]==1 and r[2]==1: both.append(r[0])

alice.sort()
bob.sort()
if len(both)+min(len(alice), len(bob))>=k:
    for i in range(min(len(alice), len(bob))):
        both.append(alice[i]+bob[i])
    both.sort()
    print(sum(both[:k]))
else:
    print(-1)