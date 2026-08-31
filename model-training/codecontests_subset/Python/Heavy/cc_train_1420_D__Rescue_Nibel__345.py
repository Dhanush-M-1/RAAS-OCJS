import math
m = 998244353
n, k = map(int, input().split())
fact = [1]
for i in range(1,n+1):
    fact.append((fact[-1]*i)%m)
ifactn = pow(fact[-1], m-2, m)
ifact = [ifactn]*(n+1)
for i in range(n-1,-1,-1):
    ifact[i] = (ifact[i+1]*(i+1))%m
choose = []
for i in range(k-1,n+1):
    choose.append(((((fact[i]*(ifact[k-1])))%m)*ifact[i-k+1])%m)
event = []
for i in range(n):
    inp = input().split()
    event.append(int(inp[0])*2)
    event.append(int(inp[1])*2+1)
event.sort()
val = 0
curr = 0
for e in event:
    if e%2==0:
        curr+=1
    else:
        if curr>=k:
            val= (val+choose[curr-k])%m
        curr-=1
print(val)