n,k = [int(x) for x in input().strip().split()]
vec = []
for _ in range(n):
    vec.append([int(x) for x in input().split()])
vec.sort()
f1 = f2 = f3 = 0
minsum = 0
count = 0
min_12 = min_3 = 0
flag12 = flag3 = True

while ((f3 <= n-1 or (f1 <= n-1 and f2 <= n-1)) and count < k):
    while f3 <= n-1:
        if vec[f3][1] == 1 and vec[f3][2] == 1:
            break
        f3 += 1
    if f3 <= n-1:
        min_3 = vec[f3][0]
    else:
        flag3 = False

    while f2 <= n-1:
        if vec[f2][1] == 1 and vec[f2][2] == 0:
            break
        f2 += 1
    while f1 <= n-1:
        if vec[f1][1] == 0 and vec[f1][2] == 1:
            break
        f1 += 1
    if f1 <= n-1 and f2 <= n-1:
        min_12 = vec[f1][0] + vec[f2][0]
    else:
        flag12 = False
    if flag12 and flag3:
        count +=1
        if min_3 <= min_12:
            f3 += 1
            minsum += min_3
        else:
            f1 += 1
            f2 += 1
            minsum += min_12
            
    elif flag12:
        count += 1
        f1 += 1
        f2 += 1
        minsum += min_12
    elif flag3:
        count += 1
        f3 += 1
        minsum += min_3
if count == k:
    print(minsum)
else:
    print(-1)
		 	 		    		 	  	  	 				  	