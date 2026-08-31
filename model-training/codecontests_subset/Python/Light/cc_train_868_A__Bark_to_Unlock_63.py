def test():
	string  = input()
	n = input()
	n = int(n)
	arr = []
	for i in range(n):
	    temp = input()
	    if temp == string:
	    	print('YES')
	    	return
	    arr.append(temp)

	for i in range(len(arr)):
	    for j in range(len(arr)):
	    	if arr[i][1] + arr[j][0] == string:
	    		print('YES')
	    		return
	print('NO')
test()
