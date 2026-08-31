
t = int(input())
for _ in range(t):

	n = int(input())
	prevplay = 0
	prevclear = 0
	flag = 0
	l = []
	for _ in range(n):
		l.append(list(map(int, input().split())))

	for i in range(n):
		play, clear = l[i][0], l[i][1]
		if play < clear:
			print('no')
			flag = 1
			break

		if play < prevplay or clear < prevclear:
			print('no')
			flag = 1
			break

		dc = clear - prevclear
		dp = play - prevplay

		if dp < dc:
			print('no')
			flag = 1
			break

		prevclear = clear
		prevplay = play


	if flag != 1:
		print('yes')
		