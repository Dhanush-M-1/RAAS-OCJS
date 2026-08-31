n = int(input())
arr = list(map(int,input().split(' ')))
odd = []
even = []
for i in range (n):
    if arr[i] % 2 == 0:
        even.append(arr[i])
    else:
        odd.append(arr[i])

odd = sorted(odd)
even = sorted(even)

if len(even)>len(odd):
    p = 'e'
    while len(odd) > 0 and len(even) > 0:
        if p == 'e':
            even.pop(len(even)-1)
            p = 'o'
        else:
            odd.pop(len(odd)-1)
            p = 'e'
    if p == 'o' and len(odd)!= 0:
        odd.pop(len(odd)-1)
    elif p == 'e'and len(even) != 0:
        even.pop(len(even)-1)
else:
    p = 'o'
    while len(odd) > 0 and len(even) > 0:
        if p == 'e':
            even.pop(len(even) - 1)
            p = 'o'
        else:
            odd.pop(len(odd) - 1)
            p = 'e'
    if p == 'o' and len(odd) != 0:
        odd.pop(len(odd) - 1)
    elif p == 'e' and len(even) != 0:
        even.pop(len(even) - 1)

print(sum(odd)+sum(even))


