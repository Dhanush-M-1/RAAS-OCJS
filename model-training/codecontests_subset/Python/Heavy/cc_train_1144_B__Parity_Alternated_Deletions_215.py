n = int(input())
a = [int(x) for x in input().split()]
a.sort(reverse=True)
odd_total = 0
even_total = 0
odd = bool(False)

for i in range(len(a)):
    if a[i] % 2 == 0:
        even_total += 1
    else:
        odd_total += 1

if even_total < odd_total:
    odd = True
else:
    pass

for j in range(len(a)):
    if a[j] % 2 == odd:
        del a[j]
        odd = not odd
        break
    else:
        pass
c = 0
while a and c != len(a):
    if a[c] % 2 == odd:
        del a[c]
        odd = not odd
        c = 0
        continue
    elif c < len(a):
        c += 1
    else:
        break
print(sum(a))
