n, k = map(int,input().split())
l = [int(x) for x in input().split()]
l.sort()
l.reverse()
for i in range(n):
	if k % l[i] == 0:
		print(k//l[i])
		break
