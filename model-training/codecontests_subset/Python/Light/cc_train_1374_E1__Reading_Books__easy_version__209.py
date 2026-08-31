n , k = map(int,input().split())

both_like = []
alice_like = [] 
bob_like = []

for i in range(n):
    t,a,b = map(int,input().split())
    if a and b:
        both_like.append((t,a,b))
    elif a :
        alice_like.append((t,a,b))
    elif b:
        bob_like.append((t,a,b))
    
alice_like.sort()
bob_like.sort()

for  i in range(min(len(alice_like),len(bob_like))):
    both_like.append((alice_like[i][0]+bob_like[i][0],1,1))

both_like.sort()

if len(both_like)<k:
    print(-1)
else:
    ans = 0
    for i in range(k):
        ans+=both_like[i][0]

    print(ans)