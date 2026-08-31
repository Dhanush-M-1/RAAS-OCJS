from fractions import gcd

N = int(input())
As = list(map(int, input().split()))

A = max(As)
lst = [0]*(A+1)
rlt = [0]*(A+1)

for i in range(2, A+1):
  if lst[i] > 0:
    continue
  j = 1
  while i*j <= A:
    if lst[i*j] == 0:
      lst[i*j] = i
    j += 1
  if j == 1:
    break
    
for a in As:
  tmp = -1
  while a > 1:
    if tmp != lst[a]:
      rlt[lst[a]] += 1
      tmp = lst[a]
    a //= lst[a]

r = max(rlt) 

if r < 2:
  print('pairwise coprime')
elif r < N:
  print('setwise coprime')
else:
  print('not coprime')