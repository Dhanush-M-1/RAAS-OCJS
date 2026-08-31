n, m = map(int, input().split())
St = set()
for i in range(n):
    l = input().split()
    for iterator in l[1:]:
        #print(iterator)
        St.add(int(iterator))
if len(St)==m:
    print("YES")
else:
    print("NO")

	 	   					  						   			 					