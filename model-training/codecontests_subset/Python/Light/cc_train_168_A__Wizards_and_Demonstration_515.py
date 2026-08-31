import math
n,x,y=map(int,input().split())
o=(n*(y/100))-x
if o<0:
    print(0)
else:
    print(math.ceil(o))

 	 	    					 	 	  	  		 	  	 	