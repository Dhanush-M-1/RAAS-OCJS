n, p, w, d = map(int, input().split(' '))
x, y, z = 0, 0, 0

if p > n * w:
    print('-1')
    exit()
if p % d == 0:
    y = int(p/d)
    z = n - y
    if y >= 0 and z >= 0:
        print(str(x) + ' ' + str(y) + ' ' + str(z))
        exit()

for i in range(1, min([w, d])+1):
    if w % i == 0 and d % i == 0:
        k = i
if p % k != 0:
    print('-1')
    exit()
for j in range(0, n):
    z = j
    f = n - z
    if (p-d*f) % (w-d) == 0:
        x = int((p-d*f)/(w-d))
        y = f - x
        if x >= 0 and y >= 0:
            print(str(x) + ' ' + str(y) + ' ' + str(z))
            exit()
    x = j + 1
    if (p-w*x) % d == 0:
        y = int((p-w*x)/d)
        z = n - x - y
        if y >= 0 and z >= 0:
            print(str(x) + ' ' + str(y) + ' ' + str(z))
            exit()
            
print('-1')