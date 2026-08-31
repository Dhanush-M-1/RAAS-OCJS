N = int(input())
S = {'AC':0, 'WA':0, 'TLE':0, 'RE':0}
for i in range(N):
    S[input()] += 1
for a in S:
    print(a + " x " + str(S[a]))