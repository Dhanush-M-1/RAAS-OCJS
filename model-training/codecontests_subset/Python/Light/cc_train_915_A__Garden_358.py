from sys import stdin, stdout

def rdl():
	return stdin.readline().replace('\n', '')

def rds():
	return rdl().split(' ')

def si():
	return list(map(lambda x: int(x), rds()))

def wr(string):
	stdout.write(string)

def main():
	line = si()
	n, k = line[0], line[1]
	buckets = si()
	r = 100000
	for bucket in buckets:
		if (k % bucket == 0):
			t = int(k / bucket)
			if (t < r):
				r = t
	wr('{}\n'.format(r))


if __name__ == '__main__':
	main()