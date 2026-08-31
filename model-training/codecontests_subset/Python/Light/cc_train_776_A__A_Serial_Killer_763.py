l = input().split()
print(*l)
n = int(input())
for i in range(n):
    a, b = input().split()
    l.remove(a)
    l.append(b)
    print(*l)
	 			 	 			  	  			   	 	 		 	