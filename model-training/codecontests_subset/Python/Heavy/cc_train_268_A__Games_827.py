n = int(input())
home_counts = {}
away_counts = {}

for i in range(n):
    curr = input().split()

    #Interestingly, it is faster to use if and else than to call special
    #functions (because function calls are costly)
    if curr[0] in home_counts:
        home_counts[curr[0]] += 1
    else:
        home_counts[curr[0]] = 1

    if curr[1] in away_counts:
        away_counts[curr[1]] += 1
    else:
        away_counts[curr[1]] = 1

count = 0

for j in away_counts:
    if j in home_counts:
        count += home_counts[j] * away_counts[j]

print(count)
