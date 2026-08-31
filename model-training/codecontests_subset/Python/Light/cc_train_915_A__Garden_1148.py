"""
This is an implementation of https://codeforces.com/problemset/problem/915/A
"""
def solve():
	inputs = input().split()
	num_buckets = int(inputs[0])
	garden_len = int(inputs[1])
	buckets = input().split(" ")
	quickest = 1e40
	for i in range(0, len(buckets)):
		bucket = int(buckets[i])
		if garden_len % bucket == 0:
			if garden_len / bucket < quickest:
				quickest = (garden_len / bucket)
	print(int(quickest))
solve()
