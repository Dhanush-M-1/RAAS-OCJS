t=int(input())
for i in range(t):
  n=int(input())
  arr=[];c=0
  for j in range(n):
    arr.append(list(map(int,input().split())))
  if arr[0][0]<arr[0][1]:
    print('NO')
  else:
    for k in range(1,n):
      if arr[0][0]<arr[0][1]:
        print('NO')
        break
      elif arr[k][0]<arr[k-1][0] or arr[k][0]<arr[k][1] or arr[k][1]<arr[k-1][1]:
        print('NO')
        break
      elif arr[k][0]==arr[k-1][0] and arr[k][1]!=arr[k-1][1]:
        print('NO')
        break
      elif abs(arr[k-1][0]-arr[k][0])<abs(arr[k-1][1]-arr[k][1]):
        print('NO')
        break    
      else:
        c+=1
        continue
    if c==n-1:
      print('YES')    