n = int(input())

trees = []

if n==1:
  ans = 1
else:
  ans = 2


for _ in range(n):
  x,h = map(int, input().split())
  trees.append((x, x-h, x+h))

x_ = trees[0][0]

for i in range(1, n-1):
  if x_ < trees[i][1]:
    x_ = trees[i][0]
    ans+=1

  elif trees[i][2] < trees[i+1][0]:
    x_ = trees[i][2]
    ans+=1
  
  else:
    x_ = trees[i][0]

print(ans)
 			 	  	 			  				 				 	  			