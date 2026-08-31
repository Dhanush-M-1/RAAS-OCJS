def checkWin(game):
	for i in range(0,4):
		if(''.join(game[i]).find('xxx') >= 0):
			return True
	for i in range(0,4):
		x = game[0][i] + game[1][i] + game[2][i] + game[3][i]
		if(x.find('xxx') >= 0):
			return True
	for i in [0,1]:
		for j in [0,1]:
			x = game[i][j] + game[i+1][j+1] + game[i+2][j+2]
			if(x.find('xxx') >= 0):
				return True
	for i in [0,1]:
		for j in [3,2]:
			x = game[i][j] + game[i+1][j-1] + game[i+2][j-2]
			if(x.find('xxx') >= 0):
				return True
	return False
def executeProgram(game):
	for i in range(0,4):
		for j in range(0,4):
			if(game[i][j] == '.'):
				game[i][j] = 'x'
				if(checkWin(game)):
					return 'YES'
				game[i][j] = '.'
	return 'NO'

game = [list(input()), list(input()), list(input()), list(input())]
ans = executeProgram(game)
print(ans)
	 				  								 	 	  	 	 	 	 	