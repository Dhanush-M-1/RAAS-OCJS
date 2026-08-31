import  sys
from sys import stdin
def get_ints(): return map(int,sys.stdin.readline().strip().split())

if __name__ == "__main__":
	n = int(input())
	l1 = list(map(int,input().split()))
	l2 = list(map(int,input().split()))
	l3 = list(map(int,input().split()))
	print(sum(l1)-sum(l2))
	print(sum(l2)-sum(l3))

	

