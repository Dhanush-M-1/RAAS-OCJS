query = int(input())
for i in range(query):
  size = int(input())
  arr = list(map(int,input().split()))
  arr.sort()
  if arr[0]+arr[1]<=arr[size-1]:
    print(1,2,size)
  else:
    print(-1)