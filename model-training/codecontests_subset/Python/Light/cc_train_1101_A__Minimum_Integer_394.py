x = int(input())

def my_function(x, y, z):
    returnable = z
    if(z < x or z > y):
        return returnable
    else:
        returnable = y - (y % z)
        return returnable + z
           


while(x > 0):
    x -= 1
    querie = list(map(int, input().split()))
    print(my_function(querie[0], querie[1], querie[2]))
  			    	 			   			 	  		