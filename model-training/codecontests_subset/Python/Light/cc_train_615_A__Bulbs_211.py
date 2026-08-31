[n, m] = [int(x) for x in input().split()]

bulbs = set()

for i in range(n):
    bulbs.update([int(x) for x in input().split()][1:])

print(["NO", "YES"][bulbs == set([int(x) for x in range(1, m+1)])])
