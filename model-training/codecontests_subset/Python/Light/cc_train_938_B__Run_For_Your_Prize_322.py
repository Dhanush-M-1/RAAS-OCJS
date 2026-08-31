n = int(input())
arr = input()  
l = list(map(int,arr.split(' ')))
#print(l)
mx=0
for i in range(n):
  if l[i]<=500000:
    if mx < l[i]-1:
      mx = l[i]-1
  else :
    if mx < 1000000-l[i]:
      mx = 1000000-l[i]
print(mx)
