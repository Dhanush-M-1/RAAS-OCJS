t = int(input())
from math import ceil
for i in range(t):

		n = int(input())

		l = list(map(int, input().split()))

		nums = []

		max_diff = 0

		for i in range(n):

			if( l[i] != -1 ):

					if ( i > 0 and l[i - 1] == -1 ) or ( i < n-1 and l[i+1] == -1 ):

						nums.append(l[i])

					if ( i < n-1 and l[i+1] != -1):

						max_diff = max(max_diff, abs(l[i] - l[i+1]))

		diff = 0
		ans = 0

		if (len(nums) != 0):

			diff = ceil(( max(nums) - min(nums) ) / 2)
			ans =  ( max(nums) + min(nums) ) // 2

		max_diff = max(diff, max_diff)

		print(max_diff, ans)




