q = int(input())

for i in range(q):
  l, r, d= map(int, input().split())

  if (d < l):
    print(d)
    continue

  x = d
  if x <= r:
    mod = r % d
    x = r - mod + d
  print(x)

	 		 	 		   		     	 	   	    	