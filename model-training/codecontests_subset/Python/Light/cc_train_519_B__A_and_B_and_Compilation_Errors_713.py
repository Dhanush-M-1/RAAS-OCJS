def get():
    return [int(x) for x in input().split()]

n = int(input())
r1 = get()
r1.sort()
r2 = get()
r2.sort()
r3 = get()
r3.sort()

for j in range(n-1):
    if r1[j] != r2[j]:
        if r1.count(r1[j]) != r2.count(r1[j]):
            a = r1[j]
        elif r1.count(r1[j+1]) != r2.count(r1[j+1]):
            a = r1[j+1]
        break
    else:
        a = r1[-1]
        
for j in range(n-2):
    if r2[j] != r3[j]:
        if r2.count(r2[j]) != r3.count(r2[j]):
            b = r2[j]
        elif r2.count(r1[j+1]) != r3.count(r1[j+1]):
            b = r2[j+1]
        break
    else:
        b = r2[-1]
        
print(a)
print(b)