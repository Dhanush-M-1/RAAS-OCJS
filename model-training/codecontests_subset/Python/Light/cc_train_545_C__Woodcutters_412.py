from os import path
import sys,time, collections as c , math as m , pprint as p
maxx , localsys , mod = float('inf'), 0 , int(1e9 + 7) 
if (path.exists('input.txt')):	sys.stdin=open('input.txt','r') ; 	sys.stdout=open('output.txt','w')
input = sys.stdin.readline
a = [[int(x) for x in input().split()] for _ in range(int(input()))]
n = len(a) ; ans = 2
if n < 2:
	print(1) , exit()
for i in range(1 , n -1):
	if a[i][0] - a[i][1] > a[i-1][0]:
		ans+=1
	elif a[i][0] + a[i][1] < a[i+1][0]:
		ans+=1 ; a[i][0]+=a[i][1]
print(ans)