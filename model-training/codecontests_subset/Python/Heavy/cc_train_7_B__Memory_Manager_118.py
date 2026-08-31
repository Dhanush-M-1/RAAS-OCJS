commands, bytes = map(int, input().split())
s = [0] * bytes
c = 0

for i in range(commands):
	op = input().split()
	if op[0] == 'alloc':
        # n = the value written next to the "alloc" statement
		n = int(op[1])
        # search for a block
		p = min([i for i in range(bytes - n + 1) if all(not x for x in s[i : i + n])] + [bytes])
        # if fitted
		if p < bytes:
			c += 1
			print(c)
			for i in range(p, p + n):
				s[i] = c
        # if didn't fit
		else:
			print('NULL')
			
	elif op[0] == 'erase':
		x = int(op[1])
        # if command exists
		if x > 0 and s.count(x):
            # set all the cells occupied by that specific block back to 0
			for i in [i for i, v in enumerate(s) if v == x]:
				s[i] = 0
		else:
			print ('ILLEGAL_ERASE_ARGUMENT')
	else:
        # defragment
		s = ([v for v in s if v] + [0] * bytes)[ : bytes]