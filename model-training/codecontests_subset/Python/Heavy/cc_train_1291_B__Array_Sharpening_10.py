t=int(input())
for i in range(t):
  n=int(input())
  if n==1:
    ar=int(input())
  else:
    ar=list(map(int,input().split()))
  if n==1:
    print("yes")
  elif n==0:
    print("NO")
  else:
    left=-1
    for i in range(n):
      if ar[i]>=i:
        left=i
      else:
        break
    right=len(ar)
    val=0
    for j in range(n-1,-1,-1):
      if ar[j]>=val:
        val+=1
        right=j
      else:
        break
    if left>=right:
      print("Yes")
    else:
      print("No")   
    
