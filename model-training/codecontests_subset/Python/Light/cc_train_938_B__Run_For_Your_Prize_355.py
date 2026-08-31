n = int(input())
p = [int(i) for i in input().split()]

prizes = [False] * 10**6
for i in p:
    prizes[i] = True 

m = 1
f = 10**6
t = 0
cnt = 0

#too slow
while cnt < n:
    t += 1
    m += 1
    f -= 1
    if prizes[m]:
        prizes[m] = False
        cnt+=1
    if prizes[f]:
        prizes[f] = False
        cnt+=1

print(t)
