n = int(input())
input_c = [0 for i in range(n)]
input_h = [0 for i in range(n)]
for i in range(n):
	values = input().split(" ")
	input_c[i] = int(values[0])
	input_h[i] = int(values[1])
fallen = 2
if (n == 1 or n == 0):
	fallen = n
for i in range(1, n-1):	
	left_d = input_c[i] - input_c[i-1] - 1
	right_d = input_c[i+1] - input_c[i] - 1
	if (left_d >= input_h[i] and left_d > 0):
		fallen += 1
		continue;
	if (right_d >= input_h[i] and right_d > 0):
		fallen += 1
		input_c[i] += input_h[i]
		continue;
print(fallen)