N, M = map(int, input().split())

bulbs = list(range(1, M+1))

for a in range(0, N):
    bS = list(map(int, input().split()))
    del bS[0]
    for b in bS:
        if b in bulbs:
            bulbs.remove(b)

if bulbs == []:
    print("YES")
else:
    print("NO")
    
    
