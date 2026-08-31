n , k = map(int , input().split())
alice = list()
bob = list()
both = list()
for i in range(n):
    t, a, b = map(int , input().split())
    if a == 1:
        if b == 1:
            both.append(t)
        else:
            alice.append(t)
    else:
        if b == 1:
            bob.append(t)
alice = sorted(alice)
bob = sorted(bob)
both = sorted(both)
final = list()

for i in range(min(len(alice) , len(bob))):
    final.append(alice[i] + bob[i])

fp = 0
bp = 0
time = 0
count = 0

while(count < k):
    if (fp+1) > len(final) and (bp+1) > len(both):
        break
    elif (fp+1) > len(final):
        time += both[bp]
        count += 1
        bp += 1
    elif (bp+1) > len(both):
        time += final[fp]
        count += 1
        fp += 1
    else:
        if final[fp] <= both[bp]:
            time += final[fp]
            count += 1
            fp += 1
        else:
            time += both[bp]
            count += 1
            bp += 1

if count >= k:
    print(time)
else:
    print(-1)
