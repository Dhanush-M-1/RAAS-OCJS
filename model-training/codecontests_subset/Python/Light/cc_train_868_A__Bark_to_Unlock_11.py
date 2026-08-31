pw = input()
n = int(input())
words = [input() for i in range(n)]

match1 = False
match2 = False
if pw in words:
	print("YES")
else:
	for word in words:
		if pw[0] == word[1]:
			match1 = True
		if pw[1] == word[0]:
			match2 = True
	if match1 and match2:
		print("YES")
	else:
		print("NO")