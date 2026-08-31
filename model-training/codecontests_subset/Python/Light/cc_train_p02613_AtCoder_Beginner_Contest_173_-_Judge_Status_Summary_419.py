S = {'AC':0, 'WA':0, 'TLE':0, 'RE':0}
for _ in range(int(input())):
	string = input()
	S[string] +=1
for s, no in S.items():
	print(s," x ",no)