from sys import stdin, stdout
rl = lambda: stdin.readline()
rll = lambda: stdin.readline().split()
cout = lambda s: stdout.write(s)
swrite = lambda s: cout(str(s))
nwrite = lambda s: cout("".join([str(s), "\n"]))

def nwrite2(s):
	cout(str(s));cout("\n")

def main():
	T = int(rl())
	numchar = lambda c: ord(c) - 97
	for _ in range(T):
		n, m = (int(x) for x in rll())
		s = rll()[0]
		P = [int(x) for x in rll()]
		freqs = [0] * 26
		for c in s:
			freqs[numchar(c)] += 1
		prefix = [0 for _ in range(len(s)+1)]
		for x in P:
			prefix[x] -= 1
		curr_sum = 0
		for i, char in enumerate(s):
			curr_sum -= prefix[i]
			freqs[numchar(char)] += m - curr_sum
		ans  = " ".join(str(x) for x in freqs)
		stdout.write(str(ans));stdout.write("\n")
		
	stdout.close()

if __name__ == "__main__":
	main()