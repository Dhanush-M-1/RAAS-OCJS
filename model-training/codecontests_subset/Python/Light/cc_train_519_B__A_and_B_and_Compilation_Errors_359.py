n = int(input())

a = list(map(int,input().split()))
b = list(map(int,input().split()))
c = list(map(int,input().split()))

a.sort()
b.sort()
c.sort()

for i in range(n-2):
    b.remove(c[i])
    a.remove(c[i])

a = sum(a)
b = sum(b)
print(a - b)
print(b)