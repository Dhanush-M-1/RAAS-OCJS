histroy = []
state = input().split(' ')

histroy.append(tuple(state))

for i in range(int(input())):
	next = input().split()
	for i in range(2):
		if next[0] == state[i]:
			state[i] = next[1]
	histroy.append(tuple(state))

for day in histroy:
	print(day[0] + " " + day[1])