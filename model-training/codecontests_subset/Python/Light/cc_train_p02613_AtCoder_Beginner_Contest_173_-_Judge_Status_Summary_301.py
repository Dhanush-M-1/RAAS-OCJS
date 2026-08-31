N=int(input())
dic={"AC":0,"WA":0,"TLE":0,"RE":0}
for i in range(N):
    s=input()
    dic[s]+=1

for s in dic.keys():
    print(s,"x",dic[s])
