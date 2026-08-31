while True:
  n =int(input())
  A=[]
  if n==0:
    break
  for i in range(n):
    num =int(input())
    A.append(num)
  cnt=0  
  for i in range(n):
    for j in range(n-1, 0, -1):
      if A[j]<A[j-1]:
        A[j], A[j-1]=A[j-1],A[j]
        cnt+=1
  print(cnt)     
