buckets, garden = list(map(int, input().split()))
sizes = list(map(int, input().split()))

sizes.sort(reverse = True)

found = False
i=0
while not found:
    time =  garden / sizes[i]
    if time.is_integer():
        found = True
    else:
        i+=1

print(int(time))

 	   				 	 		        	