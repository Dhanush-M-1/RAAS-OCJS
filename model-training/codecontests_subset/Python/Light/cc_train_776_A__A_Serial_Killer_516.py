S = set(input().split())
for x in S:
    print(x, end= ' ')    
print()
for i in range(int(input())):
    a,b=input().split()
    S.remove(a)
    S.add(b)
    
    for x in S:
        print(x, end= ' ')    
    print()