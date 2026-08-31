import sys

def input():    return sys.stdin.readline().strip()
def iinput():   return int(input())
def rinput():   return map(int, sys.stdin.readline().strip().split()) 
def get_list(): return list(map(int, sys.stdin.readline().strip().split())) 
mod = int(1e9)+7


def checkValidity(a, b, c):  
    if (a + b <= c) or (a + c <= b) or (b + c <= a) : 
        return True
    else: 
        return False

for _ in range(iinput()):
	n = iinput()
	a = get_list()

	if checkValidity(a[0], a[1], a[-1]):
		print(1, 2, n)
	else:
		print(-1)	