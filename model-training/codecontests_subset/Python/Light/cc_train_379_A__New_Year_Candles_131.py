a, b = list(map(int, input().split()))
hours = 0
x = a
hours += a

while(a >= b):
    x = a // b
    hours += x
    y = a % b
    a = x + y
        
print(hours)

	 	 	 			 	     	 		  								