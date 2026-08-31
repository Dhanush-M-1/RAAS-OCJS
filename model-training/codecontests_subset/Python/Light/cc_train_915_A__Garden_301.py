n,m = [int(i) for i in input().split()]
l = [int(i) for i in input().split()]
l.sort()
l.reverse()
for k in l:
    if m%k == 0:
        print(int(m/k))
        break
		 				 	 	    		     			 	  	