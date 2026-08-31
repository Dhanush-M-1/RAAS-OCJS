n=int(input())
d={"AC":0,"WA":0,"TLE":0,"RE":0}
for _ in range(n):
    d[input()]+=1

for i in d :
    print("{} x {}".format(i,d[i]))