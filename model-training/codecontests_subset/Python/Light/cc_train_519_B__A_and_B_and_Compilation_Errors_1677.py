def find_error(orig, solucionated):
  value = 0
  j = 0
  while(j < len(solucionated)  and value == 0):
    if(orig[j] != solucionated[j]):
      value = orig[j]
      
    j+= 1
  
  if(value == 0):
    value = orig[j]
  
  return value

n = int(input())

errors = sorted(list(map(int, input().split())))


l1 = sorted(list(map(int, input().split())))

print (find_error(errors, l1))

l2 = sorted(list(map(int, input().split())))

print(find_error(l1,l2))
	  		  	 	 	   	     				 	 			