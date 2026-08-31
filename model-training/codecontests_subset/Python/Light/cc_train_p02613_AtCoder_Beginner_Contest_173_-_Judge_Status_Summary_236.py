N = int(input())
S = list(input() for _ in range(N))
J = ["AC", "WA", "TLE", "RE"]

for judge in J:
    print(judge + " x " + str(S.count(judge)))