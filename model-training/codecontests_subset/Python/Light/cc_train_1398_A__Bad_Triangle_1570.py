t = int(input())

while t > 0:
  t -= 1
  n = int(input())
  a = list(map(int, input().split()))
  ans = [-1]
  
  if a[-1] >= a[0] + a[1]:
    ans = [1,2,n]
  if len(ans) == 1:
    print(ans[0])
  else:
    print(ans[0], ans[1], ans[2])