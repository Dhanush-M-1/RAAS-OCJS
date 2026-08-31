dic={"AC":0, 'WA':0, 'TLE':0, "RE":0}
t = int(input())
for i in range(t):
	dic[input()]+=1
for key,val in dic.items():
	print(key+" x "+str(val))