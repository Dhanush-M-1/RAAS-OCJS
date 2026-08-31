for _ in range(int(input())):
  input()
  k,n,m = list(map(int,input().split()))
  a = list(map(int,input().split()))
  b = list(map(int,input().split()))
  ans = []
  for i in range(n+m):
    if len(a)>0:
      if a[0] == 0:
        k += 1
        ans.append(a[0])
        del a[0]
        continue
    if len(b)>0:
      if b[0] == 0:
        k += 1
        ans.append(b[0])
        del b[0]
        continue
    
    if len(a)>0:
      if a[0]<=k:
        ans.append(a[0])        
        del a[0]

        continue

    if len(b)>0:
      if b[0]<=k:
        ans.append(b[0])
        del b[0]
        continue

  if len(ans) == n+m:
    ans = [str(i) for i in ans]
    print(" ".join(ans))
  else:
    print(-1)