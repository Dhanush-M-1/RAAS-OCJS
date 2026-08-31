d = {"AC":0,"WA":0,"TLE":0,"RE":0}
for _ in range(int(input())):
	a = input()
	d[a]+=1
for i in d:
	print(i ,"x",d[i])