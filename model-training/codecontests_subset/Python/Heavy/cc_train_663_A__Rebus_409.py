from sys import stdin

## basic generator
def genp( num, cnt):
	global N
	rem = num - cnt*1
	cnt2, rem2 = int(rem/(N-1)), rem%(N-1)
	# print("cnt2, rem2=", cnt2, rem2)
	for i in range( cnt2):
		yield N
	yield 1+rem2
	for i in range( cnt-cnt2-1):
		yield 1

def print_answer( plus, minus, nplus, nminus, line):
	gplus = genp( nplus, plus) if N != 1 else (1 for x in range(plus))
	# print("genp( ", nplus, plus, ")")
	gminus = genp( nminus, minus) if N != 1 else (1 for x in range(minus))
	# print("genp( ", nminus, minus, ")")
	print("%d" % next(gplus), end="")
	for i in range( 1, len(line), 2):
		if line[ i] == '+':
			print(" + %d" % next(gplus), end="")
		elif line[ i] == '-':
			print(" - %d" % next(gminus), end="")
		elif line[ i] == '=':
			print( " = %s" % line[i+1])
			break
	## end

def parse():
	global TERM, N
	line = stdin.readline().split()
	N = int( line[-1])
	plus, minus = 1, 0 ## fixed
	for i in range( 1, len(line), 2):
		if line[i] == '+':
			plus += 1
		elif line[i] == '-':
			minus += 1
	TERM= plus + minus
	## process
	## too many +
	if plus*1 - minus*N > N:
		print("Impossible")
	## too many -
	elif plus*N - minus*1 < N:
		print("Impossible")
	else:
		print("Possible")
		## make an answer
		nplus = N*plus ## max = N*plus
		nminus = minus ## max = N*minus
		if nplus-nminus != N:
			## pull down +
			d = (nplus-nminus)-N
			if d <= (N-1)*plus:
				nplus -= d
			else:
				nplus -= (N-1)*plus
				d = (nplus-nminus)-N
				nminus += d
		## print
		print_answer( plus, minus, nplus, nminus, line)


parse()