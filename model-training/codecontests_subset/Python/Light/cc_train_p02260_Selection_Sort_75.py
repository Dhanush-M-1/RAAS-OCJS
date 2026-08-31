n=int(input())
arr=list(map(int,input().split()))
cnt=0
for i in range(n):
  minp=i
  for j in range(i,n):
    if arr[minp]>arr[j]:
      minp=j
  arr[minp],arr[i]=arr[i],arr[minp]
  if minp!=i:
    cnt+=1
print(' '.join(map(str,arr)))
print(cnt)
