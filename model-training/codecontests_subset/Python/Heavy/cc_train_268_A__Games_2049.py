#####--------------Template Begin-------------------#####
import sys
#input = sys.stdin.readline
def i(): #Regular input
	return input()
def ii(): #integer input
	return int(input())
def li(): #list input
	return input().split()
def mi(): #map input
	return list(map(int, input().split()))
#####---------------Template Ends-------------------######
n=ii()
games=n * (n-1)
teams=[]
ans=0
for i in range(n):
	h,a=mi()
	teams.append([h,a])
for i in teams:
	for j in teams:
		if i[0]==j[1]:
			ans+=1
print(ans)

