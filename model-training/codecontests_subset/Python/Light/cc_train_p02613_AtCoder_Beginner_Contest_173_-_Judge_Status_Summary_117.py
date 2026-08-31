N=int(input())
dic={"AC":0,"WA":0,"TLE":0,"RE":0}
for i in range(N):
    s=input()
    dic[s]+=1
for k,v in dic.items():
    print(k,"x",v)
