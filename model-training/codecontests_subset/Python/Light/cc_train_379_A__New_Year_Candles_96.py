a, b = map(int, input().split())
r = 0
res = 0
while(True):
    a = a - 1
    res = res + 1
    r = r + 1
    if(r >= b): 
        r = r - b
        a = a + 1
    if a == 0: break
print(res)
		   	 	   			       		  	  	