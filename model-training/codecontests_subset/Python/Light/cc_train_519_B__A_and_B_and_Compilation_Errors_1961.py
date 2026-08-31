n = int(input())
first = [int(x) for x in input().split()]
second = [int(x) for x in input().split()]
third = [int(x) for x in input().split()]
first.sort()
third.sort()
ans = []
i, j = 0, 0
while i < len(first):
	if j >= len(third) or first[i] != third[j]:
		ans.append(first[i])
		i += 1
		continue
	i += 1
	j += 1
if second.count(ans[0]) == first.count(ans[0]):
	print(ans[1], ans[0], sep = "\n")
else:
	print(ans[0], ans[1], sep = "\n")