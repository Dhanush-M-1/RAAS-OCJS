Test = int(input())
for i in range(Test):
  length = int(input())
  array = list(map(int,input().split()))
  if array[-1] >= array[0] + array[1] : print(1,2,length)
  else : print(-1)