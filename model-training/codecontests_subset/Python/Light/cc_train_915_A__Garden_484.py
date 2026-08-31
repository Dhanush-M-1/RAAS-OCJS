n, k = input().split(' ')
a = input().split(' ')

n = int(n)
k = int(k)

y = 1

for x in a:
    if k % int(x) == 0 and int(x) > y:
        y = int(x)

print(k // y)
