# import sys 
# sys.stdin = open('input.txt', 'r')  
# sys.stdout = open('output.txt', 'w') 

from collections import defaultdict, deque

def solve():
	n = int(input())
	sq = []
	ans = []
	c = 0
	for i in range(n):
		sq.append(input())
	if sq[0][1] == sq[1][0]:
		if sq[-1][-2]==sq[0][1]:
			c+=1
			ans.append((n, n-1))
		if sq[-2][-1]==sq[0][1]:
			c+=1
			ans.append((n-1, n))
	elif sq[-1][-2] == sq[-2][-1]:
		#print("working")
		if sq[0][1]==sq[-1][-2]:
			c+=1
			ans.append((1, 2))
		if sq[1][0]==sq[-1][-2]:
			c+=1
			ans.append((2, 1))
	else:
		c = 2
		if sq[0][1] == '1':
			ans.append((1, 2))
		else:
			ans.append((2, 1))
		#print(sq[-1][-2])
		if sq[-1][-2] == '0':
			ans.append((n, n-1))
		else:
			ans.append((n-1, n))
	print(c)
	for i in ans:
		print(i[0], i[1])

def main():
	t = 1
	t = int(input())
	for _ in range(t):
		solve()
main()