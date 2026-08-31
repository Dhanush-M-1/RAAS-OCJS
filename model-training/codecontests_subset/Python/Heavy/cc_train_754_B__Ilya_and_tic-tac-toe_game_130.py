from sys import stdin ,stdout
from os import path
rd = lambda:stdin.readline().strip()
wr = stdout.write
if(path.exists('input.txt')):
    stdin = open("input.txt","r")
import time ,math
#------------------------------------=
mylist= []
for i in range(4):
	mylist.append(rd())
def validUpOrDown(x,y):
	if x+2 < 4 :
		counterX = counterD = 0
		for i in range(x,x+3):
			if mylist[i][y] == 'x':
				counterX+=1
			elif mylist[i][y] == '.':
				counterD +=1
		if counterD == 1 and counterX == 2:
			return True
	if x-2 >= 0 :
		counterX = counterD = 0
		for i in range(x,x-3,-1):
			if mylist[i][y] == 'x':
				counterX+=1
			elif mylist[i][y] == '.':
				counterD +=1
		if counterD == 1 and counterX == 2:
			return True
def validLeftOrRight(x,y):
	if y+2 < 4 :
		counterX = counterD = 0
		for i in range(y,y+3):
			if mylist[x][i] == 'x':
				counterX+=1
			elif mylist[x][i] == '.':
				counterD +=1
		if counterD == 1 and counterX == 2:
			return True
	if y-2 >= 0 :
		counterX = counterD = 0
		for i in range(y,y-3,-1):
			if mylist[x][i] == 'x':
				counterX+=1
			elif mylist[x][i] == '.':
				counterD +=1
		if counterD == 1 and counterX == 2:
			return True
def validDiagonal(x,y):
	if x+2 < 4 and y+2 < 4:
		counter = counterX = counterD =0 
		x1,y1 = x,y
		while  counter < 3:
			if mylist[x1][y1] == 'x':
				counterX +=1
			elif mylist[x1][y1] =='.':
				counterD+=1
			counter+=1
			x1+=1
			y1+=1
		if counterX == 2 and counterD ==1 :
			return True
	if x+2 < 4 and y-2 >= 0:
		counter = counterX = counterD =0 
		x1,y1 = x,y
		while  counter < 3:
			if mylist[x1][y1] == 'x':
				counterX +=1
			elif mylist[x1][y1] =='.':
				counterD+=1
			counter+=1
			x1+=1
			y1-=1
		if counterX == 2 and counterD ==1 :
			return True

	if x-2 >= 0 and y+2 < 4:
		counter = counterX = counterD =0 
		x1,y1 = x,y
		while  counter < 3:
			if mylist[x1][y1] == 'x':
				counterX +=1
			elif mylist[x1][y1] =='.':
				counterD+=1
			counter+=1
			x1-=1
			y1+=1
		if counterX == 2 and counterD ==1 :
			return True

	if x-2 >= 0 and y-2>=0:
		counter = counterX = counterD =0 
		x1,y1 = x,y
		while  counter < 3:
			if mylist[x1][y1] == 'x':
				counterX +=1
			elif mylist[x1][y1] =='.':
				counterD+=1
			counter+=1
			x1-=1
			y1-=1
		if counterX == 2 and counterD ==1 :
			return True
wrong = True
for i in range(len(mylist)):
	for j in range(len(mylist[i])):
		if mylist[i][j] == 'x':
			if validLeftOrRight(i,j) == True or validUpOrDown(i,j) == True or validDiagonal(i,j) == True:
				wrong = False
				break
print("YES" if wrong == False else "NO")