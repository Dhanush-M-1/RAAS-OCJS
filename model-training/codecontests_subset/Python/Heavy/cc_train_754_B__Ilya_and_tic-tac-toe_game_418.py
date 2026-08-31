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
arr = set()
for i in range(4):
	arr.add(mylist[i][0:3])
	arr.add(mylist[i][1:])
	arr.add(mylist[0][i]+mylist[1][i]+mylist[2][i])
	arr.add(mylist[1][i]+mylist[2][i] +mylist[3][i])
for i in range(2):
	for j in range(2):
		arr.add(mylist[i][j]+mylist[i+1][j+1]+mylist[i+2][j+2])
		arr.add(mylist[3-i][j]+mylist[2-i][j+1]+mylist[1-i][j+2])
print("YES" if{'.xx','x.x','xx.'}&arr  else "NO")