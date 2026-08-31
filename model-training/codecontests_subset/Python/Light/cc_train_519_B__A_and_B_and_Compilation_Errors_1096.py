n=int(input())
l=list(map(int,input().split()))
for _ in range (2):
  l1=list(map(int,input().split()))
  l.sort()
  l1.sort()
  count=0
  for i in range(len(l1)):
    if l[i]==l1[i]:
      count+=1
    if (l[i]!=l1[i]):
      print(l[i])
      break
  if (count==len(l1)):
    print(l[-1])
  l=l1

