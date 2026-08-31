import sys
n, k = map(int, input().split(' '))
number = [int(i) for i in input().split(' ')]
min = 101
for i in number:
	if k % i == 0 and k//i < min:
		min = k//i
		#print(i, k//i, min)
print(min)