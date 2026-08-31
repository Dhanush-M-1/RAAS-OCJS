counts = input().split()
x = []
canOn = []
for i in range(int(counts[0])):
    n = list(map(int,input().split()))
    canOn.append(n[1:])
s = set([item for subList in canOn for item in subList])
if (s == set(range(1,int(counts[1])+1))):
    print("YES")
else:
    print("NO")
