import sys
n = input()

def check(nums):
	down = None
	for i in range(len(nums)):
		if down is not None:
			if down <= nums[i]:
				down = down - 1
				if down < 0:
					return False
			else:
				down = nums[i]
		else:
			if nums[i] < i:
				if nums[i] < nums[i-1]:
					down = nums[i]
				else:
					down = nums[i-1]-1
					if down < 0:
						return False
	return True

def solve(nums):
	if len(nums) <= 1:
		return "Yes"

	if check(nums):
		return "Yes"

	nums.reverse()
	if check(nums):
		return "Yes"
	return "No"

for _ in range(int(n)):
	k = input()
	nums = [int(s) for s in sys.stdin.readline().split(" ")]
	print(solve(nums))
