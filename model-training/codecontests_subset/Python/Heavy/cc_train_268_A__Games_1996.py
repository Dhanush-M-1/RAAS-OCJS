if __name__ == '__main__':
	s = int(input())
	totalArr = []
	firstDic = {}
	secondDic = {}
	firstUnique = []
	secondUnique = []
	while s > 0:
		l = input().split()
		initArr = [int(x) for x in l]
		one, two = initArr
		if firstDic.get(one, 0) == 0:
			firstDic[one] = 1
			firstUnique.append(one)
		else:
			firstDic[one] += 1
		if secondDic.get(two, 0) == 0:
			secondDic[two] = 1
			secondUnique.append(two)
		else:
			secondDic[two] += 1
		s -= 1
	count = 0
	for i in firstUnique:
		count += firstDic.get(i, 0) * secondDic.get(i, 0)
	print(count)