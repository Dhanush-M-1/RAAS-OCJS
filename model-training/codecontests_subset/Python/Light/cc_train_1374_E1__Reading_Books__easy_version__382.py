n,k = map(int,input().split(" "))
both = []
alice = []
bob = []
for i in range(n):
    t,a,b=map(int,input().split())
    if (a == 1 and b == 1):
        both.append(t)
    elif (a == 1):
        alice.append(t)
    elif (b == 1):
        bob.append(t)
alice.sort();
bob.sort()
for i in range(min(len(bob),len(alice))):
    both.append(bob[i] + alice[i])
both.sort()
if (len(both) < k):
    print(-1)
else:
    print(sum(both[:k]))