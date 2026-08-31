n = input()
l = [list(map(int, input().split())) for i in range(3)]
for i in range(1,3,1):
	print(sum(l[i-1]) - sum(l[i]))
