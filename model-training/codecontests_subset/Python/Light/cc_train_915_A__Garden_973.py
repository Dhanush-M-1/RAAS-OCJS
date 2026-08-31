a, b = map(int, input().split())
l = list(map(int, input().split()))
c = 0
for i in range(a):
    if b % l[i] == 0 and l[i] > c:
        c = l[i]
print(b // c)