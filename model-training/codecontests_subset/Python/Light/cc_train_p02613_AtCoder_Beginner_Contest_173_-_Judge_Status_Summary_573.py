f = {"AC":0, "WA":0, "TLE":0,"RE":0}
for i in range(int(input())):
    s = input()
    f[s]+=1
for i in f:
    print(i,"x", f[i])