mat = []
for i in range(4):
	mat.append(list(input()))
ok = False
for i in range(4):
	if(mat[i][0]=='x' and mat[i][1]=='x' and mat[i][2]=='.'):
		ok=True
	elif(mat[i][0]=='x' and mat[i][1]=='.' and mat[i][2]=='x'):
		ok=True
	elif(mat[i][0]=='.' and mat[i][1]=='x' and mat[i][2]=='x'):
		ok=True
	if(mat[i][3]=='x' and mat[i][1]=='x' and mat[i][2]=='.'):
		ok=True
	elif(mat[i][3]=='x' and mat[i][1]=='.' and mat[i][2]=='x'):
		ok=True
	elif(mat[i][3]=='.' and mat[i][1]=='x' and mat[i][2]=='x'):
		ok=True
for i in range(4):
	if(mat[0][i]=='x' and mat[1][i]=='x' and mat[2][i]=='.'):
		ok=True
	elif(mat[0][i]=='x' and mat[1][i]=='.' and mat[2][i]=='x'):
		ok=True
	elif(mat[0][i]=='.' and mat[1][i]=='x' and mat[2][i]=='x'):
		ok=True
	if(mat[3][i]=='x' and mat[1][i]=='x' and mat[2][i]=='.'):
		ok=True
	elif(mat[3][i]=='x' and mat[1][i]=='.' and mat[2][i]=='x'):
		ok=True
	elif(mat[3][i]=='.' and mat[1][i]=='x' and mat[2][i]=='x'):
		ok=True

if(mat[0][0]=='x' and mat[1][1]=='x' and mat[2][2]=='.'):
	ok = True
elif(mat[0][0]=='x' and mat[1][1]=='.' and mat[2][2]=='x'):
	ok = True
elif(mat[0][0]=='.' and mat[1][1]=='x' and mat[2][2]=='x'):
	ok = True

if(mat[0][1]=='x' and mat[1][2]=='x' and mat[2][3]=='.'):
	ok = True
elif(mat[0][1]=='x' and mat[1][2]=='.' and mat[2][3]=='x'):
	ok = True
elif(mat[0][1]=='.' and mat[1][2]=='x' and mat[2][3]=='x'):
	ok = True

if(mat[0][2]=='x' and mat[1][1]=='x' and mat[2][0]=='.'):
	ok = True
elif(mat[0][2]=='x' and mat[1][1]=='.' and mat[2][0]=='x'):
	ok = True
elif(mat[0][2]=='.' and mat[1][1]=='x' and mat[2][0]=='x'):
	ok = True

if(mat[0][3]=='x' and mat[1][2]=='x' and mat[2][1]=='.'):
	ok = True
elif(mat[0][3]=='x' and mat[1][2]=='.' and mat[2][1]=='x'):
	ok = True
elif(mat[0][3]=='.' and mat[1][2]=='x' and mat[2][1]=='x'):
	ok = True

if(mat[1][0]=='x' and mat[2][1]=='x' and mat[3][2]=='.'):
	ok = True
elif(mat[1][0]=='x' and mat[2][1]=='.' and mat[3][2]=='x'):
	ok = True
elif(mat[1][0]=='.' and mat[2][1]=='x' and mat[3][2]=='x'):
	ok = True

if(mat[1][1]=='x' and mat[2][2]=='x' and mat[3][3]=='.'):
	ok = True
elif(mat[1][1]=='x' and mat[2][2]=='.' and mat[3][3]=='x'):
	ok = True
elif(mat[1][1]=='.' and mat[2][2]=='x' and mat[3][3]=='x'):
	ok = True

if(mat[1][2]=='x' and mat[2][1]=='x' and mat[3][0]=='.'):
	ok = True
elif(mat[1][2]=='x' and mat[2][1]=='.' and mat[3][0]=='x'):
	ok = True
elif(mat[1][2]=='.' and mat[2][1]=='x' and mat[3][0]=='x'):
	ok = True

if(mat[1][3]=='x' and mat[2][2]=='x' and mat[3][1]=='.'):
	ok = True
elif(mat[1][3]=='x' and mat[2][2]=='.' and mat[3][1]=='x'):
	ok = True
elif(mat[1][3]=='.' and mat[2][2]=='x' and mat[3][1]=='x'):
	ok = True

if(ok==True):
	print("YES")
else:
	print("NO")