n, k = map(int, input().split())
ls = list(map(int, input().split()))

ls.sort()

d = {ls[0]: 1}
i = 1
l1 = [ls[0]]

while i < n:
    if ls[i] > ls[i - 1]:
        l1.append(ls[i])
        d[ls[i]] = 1
    else:
        d[ls[i]] += 1
    i += 1

l2 = [i - k for i in l1]

#print(l1, l2)
#print(d)

i = 0
j = 1
dec = 0
while i < len(l1) and j < len(l2):
    if i == j:
        j += 1
    elif l1[i] >= l2[j]:# and ls[i] < ls[j]:
        dec += 1 * d[l1[i]]
        i += 1
    else:
        i += 1

print(n - dec)
