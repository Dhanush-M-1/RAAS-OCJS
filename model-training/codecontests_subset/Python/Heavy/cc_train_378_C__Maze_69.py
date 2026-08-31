# ------------------------------------------------------
def printTheLab():
	global n
	global m
	global lab
	for i in range(n):
		s = ''
		for j in range(m):
			if (lab[i][j] == 0) or (lab[i][j] == -1):
				s += '.'
			elif lab[i][j] == 1:
				s += '#'
			elif lab[i][j] == 2:
				s += 'X'
			else:
				s += '?'
		print(s)


# -------- main program --------------------------------
n, m, k = map(int, input().split())

lab = []
lab_path = []  # в каждый элемент добавляем

for i in range(n):
	s = input()
	s1 = s.replace('#', '1 ')
	s2 = s1.replace('.', '0 ')
	stroka_lab = list(map(int, s2.split()))
	lab.append(stroka_lab)
	
	stroka_lab_path = [[-1, -1] for j in range(m)]
	lab_path.append(stroka_lab_path)
	
# print(lab)
# print(lab_path)
# в lab_path в каждой клетке хранятся две координаты - ОТКУДА в эту клетку пришли

# найти первую пустую клетку
emptyFound = False
i = 0
while not emptyFound:
	row1 = i//m
	col1 = i%m

	if lab[row1][col1] == 0:
		emptyFound = True

	i += 1

# row1, col1 - строка и столбец первой пустой клетки
i = row1
j = col1
while k > 0:
	lab[i][j] = -1  # минус один - наш путь
	if (j > 0) and (lab[i][j - 1] == 0):  # можно пробовать влево
		lab_path[i][j-1][0] = i
		lab_path[i][j-1][1] = j
		
		# переход влево
		i = i
		j -= 1
		
	elif (i<n-1) and (lab[i+1][j]==0):  # можно пробовать вниз
		lab_path[i+1][j][0] = i
		lab_path[i+1][j][1] = j
		
		# переход вниз
		i += 1
		j = j
		
	elif (j<m-1) and (lab[i][j+1]==0):  # можно пробовать вправо
		lab_path[i][j+1][0] = i
		lab_path[i][j+1][1] = j
		
		# переход вправо
		i = i
		j += 1
		
	elif (i>0) and (lab[i-1][j]==0):    # можно пробовать вверх
		lab_path[i-1][j][0] = i
		lab_path[i-1][j][1] = j
		
		# переход вверх
		i -= 1
		j = j
	
	else:
		# из этой клетки идти уже некуда
		# здесь и ставим стену
		lab[i][j] = 2  # двойка - стена
		k -= 1
		
		# и переходим обратно
		i1 = lab_path[i][j][0]
		j1 = lab_path[i][j][1]
		if (i1==-1) and (j1==-1):
			# куда идти из первой клетки?
			# найти свободную
			if (j1 > 0) and (lab[i1][j1 - 1] == 0):  # можно пробовать влево
				i1 = i1
				j1 -= 1
			elif (i1 < n - 1) and (lab[i1 + 1][j1] == 0):  # можно пробовать вниз
				i1 += 1
				j1 = j1
			
			elif (j1 < m - 1) and (lab[i1][j1 + 1] == 0):  # можно пробовать вправо
				i1 = i1
				j1 += 1
			
			else: # ТУТ УЖ ТОЧНО (i1 > 0) and (lab[i1 - 1][j1] == 0):  # можно пробовать вверх
				i1 -= 1
				j1 = j1
		else:
			i = i1
			j = j1

printTheLab()
