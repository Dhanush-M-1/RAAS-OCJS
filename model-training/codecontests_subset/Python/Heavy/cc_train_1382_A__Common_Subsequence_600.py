def common_elements(a, b, n, m):
  D,E,common=[],[],[] 
  i, j, lc, ld = 0, 0, 0, 0
  while i < n and j < m:
    if a[i] == b[j]:
      common.append(a[i])
      lc+=1
      break
      i += 1
      j += 1
    elif a[i] < b[j]:
      D.append(a[i])
      ld+=1
      i += 1
    else:
      E.append(b[j])
      j += 1
  """if(i==n):
    while(j!=n):
      E.append(b[j])
      j+=1
  if(j==n):
    while(i!=n):
      D.append(a[i])
      ld+=1
      i+=1"""  
  return D,E,common,ld,lc

g=int(input())
for _ in range(g):
  n,m=map(int,input().split())
  a=list(map(int,input().split(" ")))
  b=list(map(int,input().split(" ")))
  a.sort()
  b.sort()
  D,E,common,ld,lc=common_elements(a, b, n, m)
  if(lc==1):
  	print("YES")
  	print("1",common[0])
  else:
  	print("NO")