n, k = tuple(map(int, input().split()))

alice = []
bob = []
both = []
for _ in range(n):
    t, a, b = tuple(map(int, input().split()))
    if a == 1 and b == 1:
        both.append(t)
    elif a == 1:
        alice.append(t)
    elif b == 1:
        bob.append(t)

both.sort()
alice.sort()
bob.sort()
remain = 0
if k <= len(both):
    result = sum(both[:k])
else:
    remain = k - len(both)
    if remain > len(bob) or remain > len(alice):
        result = -1
    else:
        result = sum(both)
        result += sum(alice[:remain]) + sum(bob[:remain])


index = max(0, k - len(both))
lenbob = len(bob)
lenalice = len(alice)
if result != -1:
    for i in range(min(k, len(both)) - 1, -1, -1):
        if index > lenbob - 1 or index > lenalice - 1:
            break
        newresult = result - both[i] + alice[index] + bob[index]
        index += 1
        if newresult < result:
            result = newresult
        else:
            break
        
print(result)
