answers = []
for _ in range(int(input())):
	n = input()
	a = list(map(int, input().strip().split(' ')))
	if(a[0] + a[1] <= a[-1]):
		answers.append('1 2 {}'.format(len(a)))
	else:
		answers.append('-1')

for answer in answers:
	print(answer)