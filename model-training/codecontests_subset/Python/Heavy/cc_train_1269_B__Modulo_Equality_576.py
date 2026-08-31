
n,m = list(map(int,input().split()))

a = list(map(int,input().split()))
b = list(map(int,input().split()))

dicb = {}

for i in range(n):
    if(b[i] not in dicb):
        dicb[b[i]] = 1

    else:
        dicb[b[i]] += 1
#value = b[0]
ans = 10**10
for i in range(n):
    value = (b[i] - a[0] + m)%m
    dica = {}
    for j in range(n):
        c = (a[j] + value)%m
        if(c not in dica):
            dica[c] = 1
        else:
            dica[c] += 1
    flag = 1
    for i in dicb.keys():
        if(i not in dica):
            flag = 0
            break
        elif(dicb[i] != dica[i]):
            flag = 0
            break

    if(flag == 1):
        ans = min(ans,value)

print(ans)
        

    
