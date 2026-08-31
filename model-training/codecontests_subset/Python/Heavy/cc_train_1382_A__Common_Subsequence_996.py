import sys

def input():    return sys.stdin.readline().strip()
def iinput():   return int(input())
def rinput():   return map(int, sys.stdin.readline().strip().split()) 
def get_list(): return list(map(int, sys.stdin.readline().strip().split())) 
mod = int(1e9)+7


for _ in range(iinput()):
	n, m = rinput()
	a = get_list()
	b = get_list()
	ans = []
	flag = False

	for i in range(n):
		if a[i] in b:
			flag = True
			ans = a[i]
			break

	if flag:
		print("YES")
		print(1, ans)
	else:
		print("NO")				

