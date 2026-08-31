m={"AC":0,"WA":0,"TLE":0,"RE":0}
for _ in range(int(input())):
	m[input()]+=1
for s,n in m.items():
	print(s,"x",n)