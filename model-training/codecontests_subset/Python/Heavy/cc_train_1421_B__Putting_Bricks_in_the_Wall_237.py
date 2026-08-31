for _ in range(int(input())):
	n = int(input())
	arr = []
	for i in range(n):
		arr.append(input())


	if arr[1][0] == "0" and arr[0][1] == "0" and arr[n-1][n-2] == "0" and arr[n-2][n-1] == "0":
		print(2)
		print(1,2)
		print(2,1)

	elif arr[1][0] == "0" and arr[0][1] == "0" and arr[n-1][n-2] == "0" and arr[n-2][n-1] == "1":
		print(1)
		print(n,n-1)

	elif arr[1][0] == "0" and arr[0][1] == "0" and arr[n-1][n-2] == "1" and arr[n-2][n-1] == "0":
		print(1)
		print(n-1,n)
	
	elif arr[1][0] == "0" and arr[0][1] == "0" and arr[n-1][n-2] == "1" and arr[n-2][n-1] == "1":
		print(0)

	elif arr[1][0] == "0" and arr[0][1] == "1" and arr[n-1][n-2] == "0" and arr[n-2][n-1] == "0":
		print(1)
		print(2,1)

	elif arr[1][0] == "0" and arr[0][1] == "1" and arr[n-1][n-2] == "0" and arr[n-2][n-1] == "1":
		print(2)
		print(1,2)
		print(n,n-1)

	elif arr[1][0] == "0" and arr[0][1] == "1" and arr[n-1][n-2] == "1" and arr[n-2][n-1] == "0":
		print(2)
		print(2,1)
		print(n,n-1)

	elif arr[1][0] == "0" and arr[0][1] == "1" and arr[n-1][n-2] == "1" and arr[n-2][n-1] == "1":
		print(1)
		print(1,2)

	
	elif arr[1][0] == "1" and arr[0][1] == "0" and arr[n-1][n-2] == "0" and arr[n-2][n-1] == "0":
		print(1)
		print(1,2)

	elif arr[1][0] == "1" and arr[0][1] == "0" and arr[n-1][n-2] == "0" and arr[n-2][n-1] == "1":
		print(2)
		print(2,1)
		print(n,n-1)

	elif arr[1][0] == "1" and arr[0][1] == "0" and arr[n-1][n-2] == "1" and arr[n-2][n-1] == "0":
		print(2)
		print(2,1)
		print(n-1,n)

	elif arr[1][0] == "1" and arr[0][1] == "0" and arr[n-1][n-2] == "1" and arr[n-2][n-1] == "1":
		print(1)
		print(2,1)

	elif arr[1][0] == "1" and arr[0][1] == "1" and arr[n-1][n-2] == "0" and arr[n-2][n-1] == "0":
		print(0)

	elif arr[1][0] == "1" and arr[0][1] == "1" and arr[n-1][n-2] == "0" and arr[n-2][n-1] == "1":
		print(1)
		print(n-1,n)

	
	elif arr[1][0] == "1" and arr[0][1] == "1" and arr[n-1][n-2] == "1" and arr[n-2][n-1] == "0":
		print(1)
		print(n,n-1)

	
	elif arr[1][0] == "1" and arr[0][1] == "1" and arr[n-1][n-2] == "1" and arr[n-2][n-1] == "1":
		print(2)
		print(1,2)
		print(2,1)





	

	
	





