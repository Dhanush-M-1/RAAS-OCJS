n = int(input())
L = []
for _ in range(n):
    a,b = [int(x) for x in input().split()]
    L.append((a,b))
    
tree = n-1
right = 10**10
ans = 0
while tree >= 1:
    if L[tree][0]+L[tree][1] < right:
        ans += 1
        right = L[tree][0]
        tree -= 1
    elif L[tree][0]-L[tree][1] > L[tree-1][0]:
        ans += 1
        right = L[tree][0]-L[tree][1]
        tree -= 1
    else:
        right = L[tree][0]
        tree -= 1

print(ans+1)
