# e_part_2_att_1.py
#attempted after contest
import sys

def input():
	return sys.stdin.readline().rstrip()

def input_split():
	return [int(i) for i in input().split()]

def add_book():
	global freqs, cf, cp
	# cost_change = 0
	while(True):
		if cf < freqs[cp]:
			cf += 1
			return cp
		else:
			cp += 1
			cf = 0

def remove_book():
	global freqs, cf, cp
	# cost_change = 0
	while(True):
		if cf > 0:
			cf -= 1
			return (-cp)
		else:
			cp -= 1
			cf = freqs[cp]

def make_available(b_time):
	global freqs, cf, cp
	freqs[b_time] += 1
	if b_time < cp: #had a bug here
		return b_time + remove_book()
	else:
		return 0

def make_unavailable(b_time):
	global freqs, cf, cp
	
	if b_time < cp: #had a bug here
		freqs[b_time] -= 1
		# a book was made unavailable that was being used
		return (-b_time + add_book())
	elif (b_time == cp and cf == freqs[cp]):
		freqs[b_time] -= 1
		cf -= 1		
		return (-b_time + add_book())

	else:
		freqs[b_time] -= 1
		return 0 #no change


n,m, k = input_split()
times = []
alice_likes = []
bob_likes = []
for _ in range(n):
	t, a, b = input_split()
	times.append(t)
	alice_likes.append(a)
	bob_likes.append(b)

# if (sum(alice_likes) < k or sum(bob_likes)< k):
# 	ans = -1
# else:
	#worst case choose all, but possible	
times_both = []
times_alice = []
times_bob = []
times_none = []
# books_alice = []

for book in range(n):
	if alice_likes[book] == 1 and bob_likes[book] == 1:
		times_both.append((times[book], book))
	elif alice_likes[book] == 1:
		times_alice.append((times[book], book))
	elif bob_likes[book] == 1:
		times_bob.append((times[book], book))
	else:
		times_none.append((times[book], book))
		# pass

times_both.sort()
times_alice.sort()
times_bob.sort()

# def split_list(lis):
	# return ([a for (a,b) in lis],[b for (a,b) in lis])

# books_alice = [j for (i,j) in times_alice]
# times_alice = 


started = False
possibilities = []
for i in range(k+1):
	# print('i is {}'.format(i))
	both = i
	indi = (k - i) #decreases by 1 in each iter, frees up two books
	extra = m - (both + 2*indi)
	# print('both {}, indi {}, extra {}, nu	m_both')
	if both > len(times_both) or indi > min(len(times_alice), len(times_bob)) or extra < 0:
		continue

	if not started:
		# print('Enter')
		started = True #when i comment this it works on test 10, so mere else vale mei hi  problem hai
		#initialise
		ans = sum([i for (i,j) in times_both[:both]]) 
		ans += sum( [i for (i,j) in times_alice[:indi]])
		ans += sum([ i for (i,j) in times_bob[:indi]])

		freqs = [0 for i in range(10001)]
		pending = (times_both[both:] + times_bob[indi:] + times_alice[indi:] + times_none)
		for tim, _ in pending:
			freqs[tim] += 1

		cp = 0 #current pointer
		cf = 0 #current fill
		extra_cost = 0
		count = 0
		for _ in range(extra):
			extra_cost += add_book()

		ans += extra_cost
		possibilities.append((ans,both))
	else:
		# print('shouldnt enter here')
		# ans = 0
		#manipulate state
		last_ans = possibilities[-1][0]
		ans = last_ans
		new_book1_time = times_alice[indi][0]
		new_book2_time = times_bob[indi][0]
		old_book_time = times_both[both-1][0]
		ans += old_book_time
		ans -= new_book1_time
		ans -= new_book2_time
		ans += make_available(new_book1_time)
		ans += make_available(new_book2_time)
		ans += make_unavailable(old_book_time)
		ans += add_book()
		possibilities.append((ans,both))
# times_both = times_both + [100000]*(n- len(times_both))
# times_alice = times_alice + [100000]*(n- len(times_alice))
# times_bob = times_bob + [100000]*(n- len(times_bob))

# ans = 0
# p1, p2, p3 = 0, 0, 0
# for i in range(k):
# 	if (times_both[p1] <= times_alice[p2] + times_bob[p3]):
# 		ans += times_both[p1]
# 		p1 += 1
# 	else:
# 		ans += times_alice[p2] + times_bob[p3]
# 		p2 += 1
# 		p3 += 1

# times_bob

if len(possibilities) == 0:
	print(-1)
else:
	ans , both = min(possibilities)
	# picked = [False for i in range(n)]
	# for b in range(n):
	indi = k - both
	extra = m - (indi*2 + both)
	books = []
	books += [j for (i,j) in times_both[:both]]
	books += [j for (i,j) in times_alice[:indi]]
	books += [j for (i,j) in times_bob[:indi]]
	pending = (times_both[both:] + times_bob[indi:] + times_alice[indi:] + times_none)
	pending.sort()
	books += [j for (i,j) in pending[:extra]]
	books = [b+1 for b in books]
	print(ans)
	print(*books, sep = ' ')
	#find the configuration and redo the stupid calculation
	#do 4 passes over all books and get the ans

