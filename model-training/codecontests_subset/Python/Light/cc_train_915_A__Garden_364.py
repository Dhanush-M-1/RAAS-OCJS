n,k=list(map(int,input().split()))
v=list(map(int,input().split()))

v.sort()
for i in range(n-1,-1,-1):
  if(k%v[i]==0):
    print(int(k/v[i]))
    break


   		  	    		 	 	     	  	