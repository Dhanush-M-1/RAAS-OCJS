n = input()
n = int(n)

c1 = input().split()
c2 = input().split()
c3 = input().split()

c1.sort()
c2.sort()
c3.sort()

ans1 = int(c1[-1])

for i in range(0,n - 1):
    if c1[i] != c2[i]:
        ans1 = int(c1[i])
        break

ans2 = int(c2[ - 1])
for i in range(0,n - 2):
    if c2[i] != c3[i]:
        ans2 = int(c2[i])
        break

print(ans1)
print(ans2)
    
