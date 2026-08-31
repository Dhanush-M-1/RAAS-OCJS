pw = input()
forw = [input() for i in range(int(input()))]
for forw1 in forw:
	for forw2 in forw:
		if pw in forw1 + forw2:
			print("YES")
			exit(0)
print("NO")