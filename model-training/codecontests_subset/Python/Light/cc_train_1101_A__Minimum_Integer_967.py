def element(queries):
    l = int(queries[0])
    r = int(queries[1])
    d = int(queries[2])
    
    if d < l or d > r:
        return d
    else:
        return (r//d + 1)*d

size = int(input())

for i in range(size):
    queries = input().split()
    elem = str(element(queries))
    print(elem)

 	 			 	   					 	 					  		