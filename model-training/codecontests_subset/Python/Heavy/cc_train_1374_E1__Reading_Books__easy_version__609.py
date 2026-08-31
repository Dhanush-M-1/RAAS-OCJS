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
        both.append(i[0])
    elif i[1] == 1:
        alice.append(i[0])
    elif i[2] == 1:
        bob.append(i[0])
if len(alice)+len(both) < k or len(bob) + len(both) <k:
    print(-1)
    exit()
both.sort()
alice.sort()
bob.sort()
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
    cost += both[i]
    b += 1
    liked += 1
while True:
    if liked == k:
        print(cost)
        break
    if b < len(both) and a<len(alice) and bb<len(bob) and both[b] <= alice[a] + bob[bb]:
        cost += both[b]
        b += 1
        liked += 1
    else:
        cost += alice[a] + bob[bb]
        bb += 1
        a += 1
        liked += 1