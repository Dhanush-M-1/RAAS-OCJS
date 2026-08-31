n = int(input())

d = {'AC':0,'WA':0,'TLE':0,'RE':0}

for i in range(n):
	s = str(input())
	d[s]+=1

for i in d.keys():
	print(i+' x '+str(d[i]))