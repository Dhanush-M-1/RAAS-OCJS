'''input
5
1 2
2 1
5 10
10 9
20 1
'''

from sys import stdin, setrecursionlimit
setrecursionlimit(1500000)


# main starts
n = int(stdin.readline().strip())
trees = []
for i in range(n):
	trees.append(list(map(int, stdin.readline().split())))

count = 1
last = trees[0][0]
i = 1
while i < n:
	x, h = trees[i]
	if i + 1 < n:
		if x - h > last:
			count += 1
			last = x
			i += 1
			continue
		else:
			if x + h < trees[i + 1][0]:
				count += 1
				last = x + h
				i += 1
				continue
			else:
				last = x
				i += 1
				continue


	else:
		count += 1
		i += 1

print(count)