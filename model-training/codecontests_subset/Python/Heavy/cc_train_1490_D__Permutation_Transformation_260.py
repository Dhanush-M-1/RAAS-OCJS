get_line = lambda type_: list(map(type_, input().strip().split()))

def helper(per, depth, start, end, ans):
	if start > end: return
	max_index = start
	for i in range(start + 1, end + 1):
		if per[i] > per[max_index]:
			max_index = i
	ans[max_index] = str(depth)
	helper(per, depth + 1, start, max_index - 1, ans)
	helper(per, depth + 1, max_index + 1, end, ans)

def solve():
	n = int(input())
	a = get_line(int)
	ans = [0] * n
	helper(a, 0, 0, n - 1, ans)
	print(' '.join(ans))

if __name__ == '__main__':
	t = int(input())
	for _ in range(t):
		solve()
