n = int(input())
prices = [int(x) for x in input().split()]
ansScore = [0] * n

for i in range(n):
  ansScore[i] = min(prices[i] - 1, 1000000 - prices[i])

print(max(ansScore))
