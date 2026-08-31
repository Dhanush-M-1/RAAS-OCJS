n, k = map(int, input().split())
alice = []
bob = []
both = []
for i in range(n):
    t, a ,b = map(int, input().split())
    if a==b==1:
        both.append(t)
    elif a==1:
        alice.append(t)
    elif b==1:
        bob.append(t)
alen = len(alice)
blen = len(bob)
mini = min(alen, blen)
alice.sort()
bob.sort()
result = []
bot_taken = 0
ab = []
for i in range(mini):
    ab .append(alice[i]+bob[i])
last_list = ab+both
last_list.sort()
if len(last_list)<k:
    print(-1)
else:
    print(sum(last_list[:k]))
