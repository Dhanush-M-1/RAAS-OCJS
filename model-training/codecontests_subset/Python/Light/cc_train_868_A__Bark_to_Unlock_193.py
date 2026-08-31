password = input()

n = int(input())
words = []

ans = False

for i in range(n):
	word = input()
	words.append(word)
	if word == password:
		ans = True

if ans:
	print("YES")

else:
	for a in words:
		first = a[1]

		for b in words:
			second = b[0]

			if first + second == password:
				ans = True
				break

		if ans:
			break

	if ans:
		print("YES")
	else:
		print("NO")