n,k = map(int, input().split())
both = []
alice = []
bob = []
for i in range(n):
	t,a,b = map(int, input().split())
	if a and b:
		both.append(t)
	elif a and not b:
		alice.append(t)
	elif not a and b:
		bob.append(t)
alice.sort()
bob.sort()

for i in range( min( len(alice), len(bob) ) ):
	both.append( alice[i] + bob[i] )
	# when both select a book of their choice then time taken = book1 + book2
	# as they both will read both books together and count += 1 for both

# there can be situtation when mutually liked book is more 
# time taking then two individual books, also if a buldle of two books 
# 1 of each favourite is selected if time of bundle is less than a single book
both.sort()

if len(both) < k:
	print(-1)
else:
	s = sum( both[:k] )
	print(s)

