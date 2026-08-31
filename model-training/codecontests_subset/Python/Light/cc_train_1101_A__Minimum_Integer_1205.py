rows = int(input())

for i in range(rows):
  nums = (input().split())
  l = int(nums[0])
  r = int(nums[1])
  d = int(nums[2])

  if (d < l):
    print(d)
    continue
  else:
    x = d
    if x <= r:
      x = r + d - (r % d)
    print(x)
   	 		 	 	   			 	  			   		