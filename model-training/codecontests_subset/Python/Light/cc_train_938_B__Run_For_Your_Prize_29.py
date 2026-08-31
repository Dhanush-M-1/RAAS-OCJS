input()
ns = [int(x) for x in input().split()]

ns = [1]+ns+[1000000]

tt = 2000000

for i in range(len(ns)-1):
    t1 = ns[i]-1
    t2 = 1000000 - ns[i+1]
    t = max(t1,t2)
    if t < tt:
        tt=t
print(tt)