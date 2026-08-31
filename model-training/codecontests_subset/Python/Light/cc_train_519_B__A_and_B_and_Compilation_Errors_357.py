def find(a , b):
    for i in range(0 , len(b)):
        if a[i] != b[i]:
            return a[i]
    return a[len(b)]
n = int(input())
a = list(map(int , input().strip().split()))[:n]
b = list(map(int , input().strip().split()))[:n-1]
c = list(map(int , input().strip().split()))[:n-2]
a.sort()
b.sort()
c.sort()
x = find(a , b)
print(x)
y = find(b , c)
print(y)