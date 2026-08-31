n,a,c = int(input()),[list(map(int, input().split())) for i in range(3)],[0,0,0]
for i in range(n):
    c[0] += a[0][i]
for i in range(n-1):
    c[1] += a[1][i]
for i in range(n-2):
    c[2] += a[2][i]
print(c[0]-c[1])
print(c[1]-c[2])
