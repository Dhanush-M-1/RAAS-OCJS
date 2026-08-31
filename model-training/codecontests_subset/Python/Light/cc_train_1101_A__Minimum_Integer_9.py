q = int(input())

for i in range(q):

    inputs = input().split()
    
    l = int(inputs[0])
    r = int(inputs[1])
    d = int(inputs[2])

    if l>d: 
        print(d)

    else: 
        x = r//d
        print(d*(x+1))

	 		  			      						 	 		  	 	