import math

def solve(xs):
	n = len(xs)
	max_vote = max(xs)
	other_votes = sum(xs)
	free = sum([max_vote - x for x in xs])
	other_votes = sum(xs)
	k = 1 + (other_votes - free + n * max_vote) // n
	return max(k, max_vote)

n = int(input())
xs = list(map(int, input().split()))[:n]
print(solve(xs))

# assert solve([1,1,1,5,1]) == 5
# assert solve([2,2,3,2,2]) == 5
# assert solve([1]) == 3
# assert solve([2]) == 5
# assert solve([2,2]) == 5
# assert solve([2,1]) == 4
# assert solve([1,2]) == 4
# assert solve([1,1,1,1]) == 3