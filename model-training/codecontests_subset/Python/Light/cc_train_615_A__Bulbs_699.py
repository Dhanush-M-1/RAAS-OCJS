n,m=[int(x) for x in input().split()];a=[];s=0
for i in range(n):
    b=[int(x) for x in input().split()]
    for j in range(b[0]):
        a.append(b[j+1])
for i in range(1,m+1):
    if i not in a:
        s=1
        break        
print(['YES','NO'][s])