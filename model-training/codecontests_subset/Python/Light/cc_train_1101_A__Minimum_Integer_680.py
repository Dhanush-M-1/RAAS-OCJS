numQuerys = int(input())

while (numQuerys != 0):
  query = input().split()
  num1, num2, num3 = int(query[0]), int(query[1]), int(query[2])

  if num1 > num3:
    print (num3)
  else:
    mod = num2%num3
    print(num2 - mod + num3)

  
  numQuerys -= 1

	 	 	 		  					  	 			   	  	