x = list(map(int,input().split()))
n = list(map(int,input().split()))
max = 1
for i in range(x[0]):
	if x[1]%n[i] == 0:
		if n[i] > max:
			max = n[i]
print(str(int(x[1]/max)))
		  		   	  		 	 	 	  		    	 	