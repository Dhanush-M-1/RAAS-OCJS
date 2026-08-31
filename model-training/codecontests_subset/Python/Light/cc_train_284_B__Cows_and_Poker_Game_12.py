n = int(input())
t = input()
if t.count("A") == 0:
	if t.count("I") == 1:
		print(1)
	else:
		print(0)
else:
	if t.count("I") == 1:
		print(1)
	elif t.count("I") > 1:
		print(0)
	else:
		print(t.count("A"))