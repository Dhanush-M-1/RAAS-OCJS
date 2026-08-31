p =input()
n =int(input())
arr =[]
for i in range(n):
	arr.append(input())
for i in range(n):
	for j in range(n):
		if p in str(arr[i]+arr[j]):
			print ("YES")
			exit()
print ("NO")