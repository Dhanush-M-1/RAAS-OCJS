import math, sys
def main():
	first, second = input().split()
	n = int(input())
	for i in range(n):
		print(first, second)
		kill, zher = input().split()
		if first == kill:
			first = zher
		if second == kill:
			second = zher
	print(first, second)
	
	
			
if __name__=="__main__":
	main()
