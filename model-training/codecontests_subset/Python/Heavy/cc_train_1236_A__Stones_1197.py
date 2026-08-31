def foo(a, b, c, ans, type):

	if type == 1:
		if min(a, b//2) == 0:
			return a, b, c, ans
		else:
			k = min(a, b//2)
			a -= k
			b -= (2*k)
			ans += (k * 3)
			return a, b, c, ans
	else:
		if min(b, c//2) == 0:
			return a, b, c, ans
		else:
			k = min(b, c//2)
			b -= k
			c -= (2*k)
			ans += (k * 3)
			return a, b, c, ans





t = int(input())
for _ in range(t):
	a,b,c = tuple(map(int, input().split()))

	a_1, b_1, c_1, ans_1 = foo(a, b, c, 0, 1)
	#print(a_1, b_1, c_1, ans_1)
	a_1, b_1, c_1, ans_1 = foo(a_1,b_1,c_1,ans_1, 2)
	#print(a_1, b_1, c_1, ans_1)

	a_2, b_2, c_2, ans_2 = foo(a, b, c, 0, 2)
	
	a_2, b_2, c_2, ans_2 = foo(a_2,b_2,c_2,ans_2, 1)
	
	print(max(ans_1, ans_2))
	