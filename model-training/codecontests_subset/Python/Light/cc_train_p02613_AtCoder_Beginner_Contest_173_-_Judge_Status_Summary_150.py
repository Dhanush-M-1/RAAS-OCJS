n=int(input())
s={"AC":0,"WA":0,"TLE":0,"RE":0}
for _ in range(n):
	key=str(input())
	s[key]+=1

for k,v in s.items():
	print("{} x {}".format(k,v))