import math
# N, M = map(int, input().split())
# A = list(map(int, input().split()))
T = int(input())
for t in range(T):
	N, M = map(int, input().split())
	S = input()
	P = list(map(int, input().split()))
	out = ["0"]*26
	pref = [0]*N
	for p in P:
		pref[p-1] += 1
	pref[N-1] = 1
	a = 0
	# print(pref)
	for n in range(N-1, -1, -1):
		tmp = pref[n]
		pref[n] += a
		a += tmp
	# print(pref)
	for n in range(N):
		# print(ord(S[n])-97)
		out[ord(S[n])-97] = str(int(out[ord(S[n])-97]) + pref[n])
		# print(pref[n])
	print(" ".join(out))