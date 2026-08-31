# @author - Kaleab Asfaw
import sys

input = sys.stdin.readline

#for _ in range(int(input())):
#lst = list(map(int, input().split()))
#def main():

# ****************************** START ********************************
def main(n, m, a, b):
	dictA = {}
	for i in a:
		dictA[i] = 1
	for i in b:
		if dictA.get(i):
			print("YES")
			return str(1) + " " + str(i)
	return "NO" 

for _ in range(int(input())):
	n, m = [int(x) for x in input().split()]
	a = list(map(int, input().split()))
	b = list(map(int, input().split()))
	print(main(n, m, a, b))
    

    
