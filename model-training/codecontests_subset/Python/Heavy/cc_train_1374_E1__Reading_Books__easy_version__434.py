from sys import stdin
inp = lambda : stdin.readline().strip()

n, k = [int(x) for x in inp().split()]
b = []
for _ in range(n):
    b.append([int(x) for x in inp().split()])
both = []
alice = []  
bob = []
for i in b:
    if i[1] == 1 and i[2] == 1:
        both.append(i[:])
    elif i[1] == 1:
        alice.append(i[:])
    elif i[2] == 1:
        bob.append(i[:])
if len(alice)+len(both) < k or len(bob) + len(both) <k:
    print(-1)
    exit()
both.sort(key = lambda x:x[0])
alice.sort(key = lambda x:x[0])
bob.sort(key = lambda x:x[0])
b = 0
a = 0
bb = 0
cost = 0
liked = 0
minimum = min(len(alice),len(bob))
x = max(k-minimum,0)
for i in range(x):
    if liked == k:
        print(cost)
        exit()
    cost += both[i][0]
    b += 1
    liked += 1
while True:
    if liked == k:
        print(cost)
        break
    if b < len(both) and a<len(alice) and bb<len(bob) and both[b][0] <= alice[a][0] + bob[bb][0]:
        cost += both[b][0]
        b += 1
        liked += 1
    else:
        cost += alice[a][0] + bob[bb][0]
        bb += 1
        a += 1
        liked += 1