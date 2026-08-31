n = int(input())

for i in range(n):
    l = list(map(int, input().split()))
    if(l[2] < l[0]):
        print(l[2])
    else:
        print((l[1]//l[2] + 1) * l[2])
	  	 			  	 		   	  		        	