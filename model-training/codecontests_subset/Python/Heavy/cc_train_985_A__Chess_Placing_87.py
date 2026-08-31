n = int(input())
givenConfig = [int(x) for x in input().split()]
sortedConfig = givenConfig
sortedConfig.sort()

moves = 0
for i in range(len(givenConfig)):
	moves += abs(givenConfig[i] - sortedConfig[i])

poss1 = [i for i in range(1, n) if i % 2 != 0]
poss2 = [i for i in range(1, n+1) if i % 2 == 0]

moves1 = 0
for i, vals in enumerate(givenConfig):
	moves1 += abs(poss1[i] - vals)

moves2 = 0
for i, vals in enumerate(givenConfig):
	moves2 += abs(poss2[i] - vals)

print(min(moves1+moves, moves2+moves))