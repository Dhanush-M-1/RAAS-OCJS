dic={'AC':0,'WA':0,'TLE':0,'RE':0}
n=int(input())
for i in range(n):
    dic[input()]+=1
for k,v in dic.items():
    print(k,"x",v)