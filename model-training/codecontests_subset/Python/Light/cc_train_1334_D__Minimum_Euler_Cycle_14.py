for _ in range(int(input())):
	numbers, LEFTs, RIGHTs = map(int, input().split())
	KEYSs = 0
	GREATS = 0
	for i in range(1, numbers+1):
		if KEYSs + 2 * (numbers-i) >= LEFTs:
			GREATS = LEFTs-KEYSs-1
			break

		KEYSs += 2 * (numbers-i)
	LISTs = []
	while len(LISTs) < (RIGHTs-LEFTs+1) + GREATS:
		for j in range(i+1, numbers+1):
			LISTs.append(i)
			LISTs.append(j)

		i += 1

		if i >= numbers:
			LISTs.append(1)
			break

	print (' '.join(list(map(str, LISTs[GREATS:GREATS+RIGHTs-LEFTs+1]))))

