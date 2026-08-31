t = int(input())
for i in range(t):
    n = int(input())
    data = list(map(int, input().strip().split()))
    arr = []
    for j in range(len(data)):
        if data[j] != -1 and ((j - 1 >= 0 and data[j - 1] == -1) or (j + 1 < len(data) and data[j + 1] == -1)):
            arr.append(data[j])
    arr.sort()
    if len(arr) == 0:
        x = 0
    else:
        x = (arr[-1] + arr[0]) // 2
    ans = 0
    for j in range(len(data)):
        if data[j] == -1:
            data[j] = x
        if j >= 1:
            ans = max(abs(data[j] - data[j - 1]), ans)
    print('%d %d' % (ans, x))

		  	    				  	 		 	  	 	  		