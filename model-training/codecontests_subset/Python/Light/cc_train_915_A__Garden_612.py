# Paulo Pacitti
# RA 185447

n, k = list(map(lambda e: int(e), input().split(" ")))
buckets = list(map(lambda e: int(e), input().split(" ")))
alternatives = []

for b in buckets:
    mod = k % b
    q = k // b
    if mod == 0:
        alternatives.append(int(k // b))

print(min(alternatives))
	    				 		     		  		 				 		