from sys import stdin
from collections import defaultdict

n, k = list(map(int, stdin.readline().rstrip().split(" ")))

alice = []
bob = []
both = []

for _ in range(n):
    ti, ai, bi = list(map(int, stdin.readline().rstrip().split(" ")))
    if ai == 1 and bi == 1:
        both.append(ti)
    elif ai == 1:
        alice.append(ti)
    elif bi == 1:
        bob.append(ti)


if len(both) + len(alice) < k or len(both) + len(bob) < k:
    print(-1)
    raise SystemExit


ki = 0

alice.sort()
bob.sort()
both.sort()

takenBooks = []
takenBooksExtra = []

for ele in both:
    takenBooks.append(ele)
    ki += 1
    if ki >= k:
        break


newIdx = 0
if ki < k:
    for i in range(min(len(alice), len(bob))):
        takenBooksExtra.append(alice[i])
        takenBooksExtra.append(bob[i])
        ki += 1
        newIdx = i + 1
        if ki == k:
            break

#print(takenBooks)
#print(takenBooksExtra)


for i in range(newIdx, min(len(alice), len(bob))):
    if len(takenBooks) == 0:
        break
    if alice[i] + bob[i] < takenBooks[-1]:
        takenBooks.pop()
        takenBooksExtra.append(alice[i])
        takenBooksExtra.append(bob[i])
    else:
        break

#print(takenBooks)
#print(takenBooksExtra)


print(sum(takenBooks) + sum(takenBooksExtra))
    