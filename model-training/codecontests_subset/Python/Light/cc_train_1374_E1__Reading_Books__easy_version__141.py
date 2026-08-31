n,k = map(int,input().split())
ali,bob,both=[],[],[]
for i in range(n):
    r,ai,bi = map(int,input().split())
    if ai and bi:both.append(r)
    elif ai:ali.append(r)
    elif bi:bob.append(r)
ali.sort()
bob.sort()
for i in range(min(len(ali),len(bob))):
    both.append(ali[i]+bob[i])
if len(both)<k:
    print(-1)
else:
    print(sum(sorted(both)[:k]))