n, k = map(int, input().split())
alice=[];bob=[];both=[]
for _ in range(n):
    x,y,z=map(int,input().split())
    if y==1 and z==1:
        both.append(x)
    elif y==1:
        alice.append(x)
    elif z==1:
        bob.append(x)
alice.sort();bob.sort()
# print(alice)
for i in range(min(len(alice),len(bob))):
    both.append(alice[i]+bob[i])
both.sort()
# print(both)
if len(both)<k:
    print(-1)
else:
    print(sum(both[:k]))