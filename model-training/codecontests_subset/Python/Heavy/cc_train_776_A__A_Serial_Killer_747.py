import sys
if False:
    practice = open('tsample_input.txt', 'r')
else:
    practice = sys.stdin

#Make it "if False" before submitting, while use it with True while testing on a sample input of ur own

a = practice.read().splitlines()
b = []

for line in a:
	c = line.split(" ")
	b.append(c)

first = b[0][0]
second = b[0][1]

print (first, second)


for j in range(len(b)-2):
	for i in range(1):
		if b[j+2][i] == first:
			first = b[j+2][i+1]
		else:
			second = b[j+2][i+1]
		print (first, second)