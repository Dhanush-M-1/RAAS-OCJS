n = int(input())
e1,e2 = 0,0
l1 = list(map(int,input().split()))
l2 = list(map(int,input().split()))
l3 = list(map(int,input().split()))

l1.sort()
l2.sort()
l3.sort()

for c in range(n-1):
  if l2[n-2 - c] != l1[n-1 - c]:
    e1 = l1[n-1 - c]
    break

if e1 == 0: 
  e1 = l1[0]

for c in range(n-2):
  if l3[n-3 - c] != l2[n-2 - c]:
    e2 = l2[n-2 - c]
    break

if e2 == 0: 
  e2 = l2[0]

print(e1)
print(e2)