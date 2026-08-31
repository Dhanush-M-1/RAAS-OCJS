n,k = [int(x) for x in input().split()]

res = 0
pick  =0
both = []
alice = []
bob = []

for i in range(n):
    t,a,b=[int(x) for x in input().split()]
    if a == 1 and b ==1:
        both.append(t)
    elif a == 1 and b == 0:
        alice.append(t)
    elif a == 0 and b == 1:
        bob.append(t)

alice.sort()
bob.sort()
both.sort()

n1,n2,n3 = len(both),len(alice),len(bob)
i,j,l = 0, 0, 0

while i  < n1 and j < n2 and l < n3:
    if both[i] <=  alice[j]  + bob[l]:
        res += both[i]
        i += 1
        pick += 1
        if pick == k:
            break
    else:
        res += alice[j] + bob[l]
        j += 1
        l += 1
        pick += 1
        if pick == k:
            break

if (j >= n2 or l >= n3):
    while i < n1:
        res += both[i]
        i += 1
        pick += 1
        if pick == k:
            break
elif (i >= n1):
    while j < n2 and l < n3:
        res += alice[j] + bob[l]
        j += 1
        l += 1
        pick += 1
        if pick == k:
            break
if pick == k:
    print(res)
else:
    print(-1)
    
