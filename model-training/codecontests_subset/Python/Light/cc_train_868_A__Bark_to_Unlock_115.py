def main():
	password = input()
	n = int(input())
	words = [None] * n
	for i in range(n):
		words[i] = input()
	print(solver(password, words))


def solver(password, words):
	if password in words:
		return "YES"
	firstletters = [word[0] for word in words]
	lastletters = [word[1] for word in words]
	if (password[0] in lastletters and 
		password[1] in firstletters):
		return "YES"
	else:
		return "NO"

#print(solver("ya", ["ah", "oy"]))
main()

#print('a' in ["a"])