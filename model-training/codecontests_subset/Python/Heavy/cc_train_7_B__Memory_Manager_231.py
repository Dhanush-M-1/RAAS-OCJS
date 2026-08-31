t, m = map(int, input().split())

c_id = 0

memory = [0 for _ in range(m)]

for i in range(t):
	cmd_arg = input()
	if cmd_arg == 'defragment':
		memory = list(filter(lambda _: _ != 0, memory))
		memory += [0 for _ in range(m - len(memory))]
	
	else:
		cmd, arg = cmd_arg.split()
		arg = int(arg)

		if cmd == 'alloc':
			success = False
			for i in range(m - arg + 1):
				if all(_ == 0 for _ in memory[i:i+arg]):
					c_id += 1
					memory[i:i+arg] = [c_id for _ in range(arg)]
					success = True
					break
			if success:
				print(c_id)
			else:
				print('NULL')

		if cmd == 'erase':
			if arg <= 0:
				print('ILLEGAL_ERASE_ARGUMENT')
			else:
				if any(_ == arg for _ in memory):
					memory = list(map(lambda _: _ if _ != arg else 0, memory))
				else:
					print('ILLEGAL_ERASE_ARGUMENT')
	
	# print(i, memory, c_id)
