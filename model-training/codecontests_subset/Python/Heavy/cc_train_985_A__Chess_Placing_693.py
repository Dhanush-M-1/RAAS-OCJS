""" 616C """
""" 1152B """
import math
# import sys
def main():
	# n ,m= map(int,input().split())
	# arr = list(map(int,input().split()))
	# b = list(map(int,input().split()))
	# n = int(input())
	# string = str(input())
	n = int(input())
	a = list(map(int,input().split()))
	a.sort()
	diff1 = 0 
	diff2 = 0
	start = 1
	for i in range(n//2):
		diff1 += abs(start-a[i])
		start+=2
	start = 2
	for i in range(n//2):
		diff2 += abs(start-a[i])
		start+=2
	print(min(diff1,diff2))
	return

main()
# def test():
# 	t = int(input())
# 	while t:
# 		main()
# 		t-=1
# test()
