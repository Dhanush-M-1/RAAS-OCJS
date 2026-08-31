v = input().split()
print(v[0] + " " + v[1])
n = int(input())
for i in range(n):
    d = input().split()
    v[ v.index(d[0]) ] = d[1]
    print(v[0] + " " + v[1])