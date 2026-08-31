de2 = {}
de3 = {}

if __name__ == '__main__':
	n = int(input().strip())
	e1 = [int(x) for x in input().strip().split(' ')]
	e2 = [int(x) for x in input().strip().split(' ')]
	e3 = [int(x) for x in input().strip().split(' ')]

	for e in e2:
		if e in de2:
			de2[e] += 1
		else:
			de2[e] = 1
	for e in e3:
		if e in de3:
			de3[e] += 1
		else:
			de3[e] = 1
	
	for e in e1:
		if e in de2 and de2[e] == 0:
			print(e)
		elif e in de2:
			de2[e] -= 1
		else:
			print(e)
	
	for e in e2:
		if e in de3 and de3[e] == 0:
			print(e)
		elif e in de3:
			de3[e] -= 1
		else:
			print(e)
