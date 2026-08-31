n = int(input())
l = int(0)
arr1 = list(map(int, input().split()))
arr2 = list(map(int, input().split()))
arr3 = list(map(int, input().split()))
if len(arr1) == n and len(arr2) == n - 1 and len(arr3) == n - 2:
	l = 1
if(l == 1):
	print(sum(arr1) - sum(arr2))
	print(sum(arr2) - sum(arr3))
	  		  			 	   		 	   			  				