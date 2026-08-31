queries = int(input())
minimums_x = []

for q in range(queries):
    l, r, d = list(map(int, input().split()))

    if d < l or d > r:
        minimums_x.append(d)
        continue

    elif r % d != 0:
        minimums_x.append(int((r / d)) * d + d)

    else:
        minimums_x.append(r + d)

for num in minimums_x:
    print(num)
   		 	      		 	  	  	 				