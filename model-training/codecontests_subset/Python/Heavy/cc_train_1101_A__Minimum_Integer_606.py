from sys import stdin

def read_lines(sep=' ', input_type=None):
    _lines = stdin.readlines()
    cast = input_type is not None
    lines = []
    for line in _lines:
        line = line[:-1].split(sep)
        if cast:
            line = [input_type(x) for x in line]
        lines.append(line)
    return lines


def sequential_max_diff(seq):
    unlagged_seq = seq[:-1]
    lagged_seq = seq[1:]
    maxd = 0
    for pair in zip(unlagged_seq, lagged_seq):
        diff = abs(pair[0]-pair[1])
        
        if diff > maxd:
            maxd= diff
    return maxd

def main2():

	lines = read_lines(input_type=int)

	n = lines[0][0]
	heights = lines[1]

	_seq=heights
	_seq.sort()
	least = _seq[-1]

	elements = _seq

	min_pair = None
	for i in range(len(elements)):
	    for j in range(len(elements)):
	        if j==i:
	            continue
	        a,b = elements[i], elements[j]
	        seq = _seq.copy()
	        seq.remove(a)
	        seq.remove(b)
	        res = max(sequential_max_diff([a]+seq+[b]), abs(a-b))
	        if res < least:
	            min_pair = (a,b)
	            least = res
	            
	seq = _seq.copy()
	seq.remove(min_pair[0])
	seq.remove(min_pair[1])
	    
	out = list(map(str, [min_pair[0]]+seq+[min_pair[1]]))
	print(' '.join(out))

def main3():

	lines = read_lines(input_type=int)

	n,m,k = lines[0]
	v = lines[1]

	# find max1 and max2

	max1=max(v)
	max2=0

	max_appears = 0
	for ele in v:
		if ele == max1:
			max_appears+=1
			if max_appears ==2:
				print(max1*m)
				return

	for ele in v:
		if ele!=max1:
			if (ele >= max2):
				max2 = ele

	block_size = k + 1

	num_of_blocks = m // block_size
	remainder = m % block_size

	value = num_of_blocks*(k*max1+max2)+remainder*max1
	print(value)

def main4():

	lines = read_lines(input_type=int)
	n = lines[0][0]

	if n%4==0:
		print(0)
	elif n%4==2:
		print(1)
	elif n%4==1:
		print(1)
	else:
		print(0)

def main():
	lines = read_lines(input_type=int)

	for line in lines[1:]:
		l, r, d = line

		if (d > r):
			print(d)
		elif (d==r):
			print(2*d)
		elif (d<l):
			print(d)
		else:
			print(d*(r//d + 1))

if __name__ == "__main__":
	main()