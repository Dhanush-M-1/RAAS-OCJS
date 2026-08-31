q = int(input())
for i in range(q):
    numbers = input().split()
    li = int(numbers[0])
    ri = int(numbers[1])
    di = int(numbers[2])
    if(li != di and li / di >= 1):
        print(di)
    else:
        k = int(ri / di)
        print((k+1) * di) 

	 	 	    	 		   			 	 				   		