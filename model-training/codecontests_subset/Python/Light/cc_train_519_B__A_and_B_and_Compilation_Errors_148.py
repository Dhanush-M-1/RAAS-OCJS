n=int(input())
l1=list(map(int,input().split()))
l2=list(map(int,input().split()))
l3=list(map(int,input().split()))

l1.sort()
l2.sort()
l3.sort()

f1=True
for i in range(len(l2)):
  if l1[i]!=l2[i]:
    print(l1[i])
    f1=False
    break
if f1:
  print(l1[-1])

f2=True
for i in range(len(l3)):
  if l2[i]!=l3[i]:
    print(l2[i])
    f2=False
    break
if f2:
  print(l2[-1])