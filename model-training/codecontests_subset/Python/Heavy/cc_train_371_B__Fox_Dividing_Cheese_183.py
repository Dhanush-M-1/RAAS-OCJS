

from collections import Counter
def solve(n):
    t = []
    while n % 2 == 0 :
        t.append(2)
        n//= 2
        
    i = 3 
    while i * i <= n :
        while n % i == 0 :
            t.append(i)
            n//= i
        i += 1

    if n > 2 :
        t.append(n)
    return t

a , b = map(int,input().split())
if a == b :print(0);exit()

#print(solve(a))
#print(solve(b))
r1 = Counter(solve(a))
r2 = Counter(solve(b))
#print(r1)
#print(r2)

cnt1 , cnt2 = 0 , 0
flag = True
for i in r1.keys() :
    if i in r2.keys() and r1[i] != r2[i]:
        if (i % 2 == 0 or i % 3 == 0 or i % 5 == 0 ):
            cnt1 += abs(r1[i] - r2[i])
        else:
            flag = False
            break

    elif i not in r2.keys():
        if (i % 2 == 0 or i % 3 == 0 or i % 5 == 0 ):
            cnt1+= r1[i]
        else:
            flag = False
            break

if flag == False:
    print('-1')
    exit(0)

for i in r2.keys() :
    if i not in r1.keys() :
        if (i % 2 == 0 or i % 3 == 0 or i % 5 == 0 ):
            cnt2 += r2[i]
        else:
            flag = False
            break
if flag == False:
    print(-1)
    exit(0)

print(cnt1 + cnt2)


