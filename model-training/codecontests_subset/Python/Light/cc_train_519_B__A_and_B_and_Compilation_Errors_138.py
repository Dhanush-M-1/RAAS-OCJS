x=int(input())
s=[int(n)  for n in input().split()]
z=[int(n)  for n in input().split()]
a=[int(n)  for n in input().split()]
s.sort()
z.sort()
a.sort()
l=0
for n in range(len(z)):
  if s[n]!=z[n]:
    l=0
    print(s[n])
    break
  else:
    l=1
if l==1:
  print(s[len(s)-1])
l=0
for n in range(len(a)):
  if a[n]!=z[n]:
    l=0
    print(z[n])
    break 
  else:
    l=1
if l==1:
  print(z[len(z)-1])