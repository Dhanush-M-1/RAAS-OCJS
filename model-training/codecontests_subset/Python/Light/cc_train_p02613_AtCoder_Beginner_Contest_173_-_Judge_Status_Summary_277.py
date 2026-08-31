d={"AC":0, "WA":0, "TLE":0, "RE":0}
for _ in range(int(input())):
    s=input()
    d[s]+=1
for i in d.keys():
    print(i," x ",d[i])
