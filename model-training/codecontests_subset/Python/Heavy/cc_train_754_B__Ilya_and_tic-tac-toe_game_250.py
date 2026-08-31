class GetOutOfLoop( Exception ):
    pass


space = []
yes = False
for i in range(4):
	space.append([i for i in input()])
for i in range(4):
	for j in range(4):
		if space[i][j] == '.':
			newSpace = space
			newSpace[i][j] = 'x'
			for m in range(4):
				score = 0
				for n in range(4):
					if newSpace[m][n] == 'x':
						score += 1
						if score == 3:
							print('YES')
							yes = True
							break
					else:
						score = 0
			if yes:
				break
			for n in range(4):
				score = 0
				for m in range(4):
					if newSpace[m][n] == 'x':
						score += 1
						if score == 3:
							print('YES')
							yes = True
							break
					else:
						score = 0
			if yes:
				break
			if newSpace[0][1] == newSpace[1][2] == newSpace[2][3] == 'x':
				yes = True
				print('YES')
				break
			if newSpace[1][0] == newSpace[2][1] == newSpace[3][2] == 'x':
				yes = True
				print('YES')
				break
			if newSpace[2][0] == newSpace[1][1] == newSpace[0][2] == 'x':
				yes = True
				print('YES')
				break
			if newSpace[3][1] == newSpace[2][2] == newSpace[1][3] == 'x':
				yes = True
				print('YES')
				break
			if newSpace[0][0] == newSpace[1][1] == newSpace[2][2] == 'x':
				yes = True
				print('YES')
				break
			if newSpace[1][1] == newSpace[2][2] == newSpace[3][3] == 'x':
				yes = True
				print('YES')
				break
			if newSpace[3][0] == newSpace[2][1] == newSpace[1][2] == 'x':
				yes = True
				print('YES')
				break
			if newSpace[2][1] == newSpace[1][2] == newSpace[0][3] == 'x':
				yes = True
				print('YES')
				break
			newSpace[i][j] = '.'
		if yes:
			break
	if yes:
		break
if yes == False:
	print('NO')