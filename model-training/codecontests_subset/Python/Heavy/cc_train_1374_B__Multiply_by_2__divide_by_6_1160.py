import sys
# import math
input = sys.stdin.readline


def int_array():
    return list(map(int, input().strip().split()))


def str_array():
    return input().strip().split()


def lower_letters():
    lowercase = [chr(i) for i in range(97, 97+26)]
    return lowercase

def how_frequent(lis):
	last = None
	count = []
	each = 1
	for i in range(len(lis)):
		if last != None:
			last = lis[i-1]
		if last == lis[i]:
			each += 1
		else:
			count.append(each)
			each = 0
		last = lis[i]
	return max(count)


def upper_letters():
    uppercase = [chr(i) for i in range(65, 65+26)]
    return uppercase

######################### TEMPLATE ENDS HERE ##################################


for _ in range(int(input())):
	n = int(input())
	count = 0
	while True:
		if n == 1:
			print(count)
			break
		if n % 6 == 0:
			n = n/6
		else:
			if n % 3 != 0:
				print(-1)
				break
			n *= 2
		count += 1
		
