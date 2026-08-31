p1, p2 = input().split()
n = int(input())

print(p1, p2)
for i in range(n):
    vic, new = input().split()
    if p1 == vic:
        p1 = new
    else:
        p2 = new
    print(p1, p2)
    			 	 	 		 	 				  			   	