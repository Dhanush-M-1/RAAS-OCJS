init = input().split()
n = int(input())
lst = [init[:]]
for x in range(n):
	inp = input().split()
	init.remove(inp[0])
	init.append(inp[1])
	lst.append(init[:])
for x in lst:
	print(" ".join(x))
		
