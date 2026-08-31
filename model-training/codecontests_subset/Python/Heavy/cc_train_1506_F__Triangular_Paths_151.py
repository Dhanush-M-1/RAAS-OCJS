'''input
4
3
1 4 2
1 3 1
2
2 4
2 3
2
1 1000000000
1 1000000000
4
3 10 5 8
2 5 2 4
'''
for t in range(int(input())):
	n = int(input())
	r_arr = tuple(map(int,input().split()))
	c_arr = tuple(map(int,input().split()))
	# print(r_arr,c_arr)
	r_rminusc = [(r,r-c,c) for r,c in zip(r_arr, c_arr)]
	r_rminusc.sort()
	# print(r_rminusc)
	cost = 0
	current_pos = (1,0,1)
	for tup3 in r_rminusc:
		diff1 = current_pos[1]
		diff2 = tup3[1]
		c11, c12 = divmod(diff1,2)
		c21, c22 = divmod(diff2,2)
		if c11 != c21:
			cost += c21 - c11
		else:
			if c22 == 0 and c12 == 0:
				cost += tup3[0] - current_pos[0]
		current_pos = tup3
	print(cost)