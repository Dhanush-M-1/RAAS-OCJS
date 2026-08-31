import sys

alphabet = "abcdefghijklmnopqrstuvwxyz"
t = int(sys.stdin.readline().strip())
 
for i in range(t):
	n, m = map(int, sys.stdin.readline().strip().split())
	s = sys.stdin.readline().strip()
	p = sorted(list(map(int, sys.stdin.readline().strip().split())))
	korrad = {}
	for j in p:
		if j not in korrad.keys():
			korrad[j] = 1
		else:
			korrad[j] += 1

	for letter in alphabet:
		if(letter != "a"):
			sys.stdout.write(" ")
		amount = [0]
		count = 0
		for j in range(n):
			if(s[j] == letter):
				count += 1
			amount.append(count)

		if(count > 0):
			count = 0
			for j in korrad.keys():
				count += amount[j]*korrad[j]
			count += amount[n]
			sys.stdout.write(str(count))
		else:
			sys.stdout.write("0")
	sys.stdout.write("\n")