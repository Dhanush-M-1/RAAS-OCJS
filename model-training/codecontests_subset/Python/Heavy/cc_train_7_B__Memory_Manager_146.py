#7B - Memory Manager
# t - number of further commands
# m - number of bytes to allocate
t, m = map(int, input().split())
# we "allocate" the bytes through s:
s = [0] * m
#Counter:
c = 0

for i in range(t):
    #Now, we take the commands in:
	op = input().split()
    #
	if op[0] == 'alloc':
        # n = the value written next to the "alloc" statement
		n = int(op[1])
        #We allocate the memory to the free blocks that are the closest to byte #1
        #So, we look for the beginning of that block:
		p = min([i for i in range(m - n + 1) if all(not x for x in s[i : i + n])] + [m])
        #If the index of the free block is not the end of the entire allocated memory array: 
		if p < m:
            #We count that as a successful operation and add print its number:
			c += 1
			print(c)
			for i in range(p, p + n):
				s[i] = c
        #If it is impossible to allocate a free block of this size,
        #the function returns NULL:
		else:
			print('NULL')
    #If the command is to erase a command:
	elif op[0] == 'erase':
        #x - The number of the command to be erased
		x = int(op[1])
        #If such command exists (command number x to be erased):
		if x > 0 and s.count(x):
            #We set all the cells occupied by that specific block back to 0
			for i in [i for i, v in enumerate(s) if v == x]:
				s[i] = 0
		else:
			print ('ILLEGAL_ERASE_ARGUMENT')
            #If the command is to fragment the memory:
	else:
        #We make the occupied blocks come closer together, to the byte #1
		s = ([v for v in s if v] + [0] * m)[ : m]