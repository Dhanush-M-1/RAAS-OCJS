q=int(input())
for i in range(q):
    l,r,d=list(map(int,input().split()))
    if(l<=d):
        print(r-r%d+d)
    else:
        print(d)
        
    
  		 			 		 	 		     	 			 	  	