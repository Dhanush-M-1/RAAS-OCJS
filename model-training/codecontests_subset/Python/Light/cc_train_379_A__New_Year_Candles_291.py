import sys
if False:
    input = open('candles.txt', 'r')
else:
    input = sys.stdin

nums = input.readline().split()
a = int(nums[0])
b = int(nums[1])
hours = a
while a >= b:
	hours = hours + (a//b)
	a = a//b + a%b
print (hours)
