n = int(input())

l1 = [int(x) for x in input().split()]
l2 = [int(y) for y in input().split()]
l3 = [int(z) for z in input().split()]

l1.sort()
l2.sort()
l3.sort()

ans1 = 0
ans2 = 0

for i in range(n-1):
    a = l1[i]
    b = l2[i]
    if a != b:
        ans1 = a
        break

if ans1 == 0:
    ans1 = l1[n-1]

for j in range(n-2):
    a = l2[j]
    b = l3[j]
    if a != b:
        ans2 = a
        break

if ans2 == 0:
    ans2 = l2[n-2]

print(ans1)
print(ans2)
