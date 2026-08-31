import sys

def input():
	return sys.stdin.readline().rstrip()

def input_split():
	return [int(i) for i in input().split()]

# testCases = int(input())
# answers = []
# for _ in range(testCases):
	#take input
n, k = input_split()
times = []
alice_likes = []
bob_likes = []
for _ in range(n):
	t, a, b = input_split()
	times.append(t)
	alice_likes.append(a)
	bob_likes.append(b)

if (sum(alice_likes) < k or sum(bob_likes)< k):
	ans = -1
else:
	#worst case choose all, but possible	
	times_both = []
	times_alice = []
	times_bob = []
	for book in range(n):
		if alice_likes[book] == 1 and bob_likes[book] == 1:
			times_both.append(times[book])
		elif alice_likes[book] == 1:
			times_alice.append(times[book])
		elif bob_likes[book] == 1:
			times_bob.append(times[book])
		else:
			pass

	times_both.sort()
	times_alice.sort()
	times_bob.sort()
	times_both = times_both + [100000]*(n- len(times_both))
	times_alice = times_alice + [100000]*(n- len(times_alice))
	times_bob = times_bob + [100000]*(n- len(times_bob))

	ans = 0
	p1, p2, p3 = 0, 0, 0
	for i in range(k):
		if (times_both[p1] <= times_alice[p2] + times_bob[p3]):
			ans += times_both[p1]
			p1 += 1
		else:
			ans += times_alice[p2] + times_bob[p3]
			p2 += 1
			p3 += 1

	# times_bob

print(ans)
	# answers.append(ans)

# print(*answers, sep = '\n')
