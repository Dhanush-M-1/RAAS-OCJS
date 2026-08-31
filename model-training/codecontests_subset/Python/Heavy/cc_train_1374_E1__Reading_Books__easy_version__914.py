import sys
from operator import itemgetter

def rl(): return sys.stdin.readline().strip()


n,k = map(int,rl().split())
booksboth = []
booksalice = []
booksbob = []
for _ in range(n):
    nb = [int(x) for x in rl().split()]
    if nb[1] == 1 and nb[2] == 1:
        booksboth.append(nb)
    elif nb[1] == 1:
        booksalice.append(nb)
    elif nb[2] == 1:
        booksbob.append(nb)
booksalice = sorted(booksalice,key=itemgetter(0))
booksbob = sorted(booksbob,key=itemgetter(0))
a = len(booksalice)
b = len(booksbob)
for i in range(min(a,b)):
    booksboth.append([booksalice[i][x]+booksbob[i][x] for x in range(3)])
booksboth = sorted(booksboth,key=itemgetter(0))
if len(booksboth) < k: print(-1)
else:
    tot = 0
    for i in range(k):
        tot += booksboth[i][0]
    print(tot)