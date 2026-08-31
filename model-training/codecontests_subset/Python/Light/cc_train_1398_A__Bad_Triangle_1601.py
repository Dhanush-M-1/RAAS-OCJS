t = int(input())

def solve():
  n = int(input())
  arr = list(map(int, input().split()))
  maximum = arr[-1]
  minimum = arr[0]
  second = arr[1]
  if(minimum + second <= maximum):
    print(1,2,len(arr))
  else:
    print(-1)
for i in range(t):
  solve()