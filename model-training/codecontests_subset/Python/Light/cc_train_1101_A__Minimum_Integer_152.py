
def min_int(inp):
	l = int(inp[0])
	r = int(inp[1])
	d = int(inp[2])
	out = -1
	i = 1
	while out == -1 :
		mult = i * d
		if mult not in range(l,r+1):
			out = mult
			break
		if mult in range(l,r+1):
			mult = r
			i = mult // d
		i = i+1
	return out


#flow of the program
q = int(input())

for i in range(0, q):
	inp = input()
	inp = inp.split()
	minimal_integer = min_int(inp)
	print(minimal_integer)
