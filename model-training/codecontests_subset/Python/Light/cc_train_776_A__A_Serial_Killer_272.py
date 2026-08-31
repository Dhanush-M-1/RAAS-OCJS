e = input().split()
print(*e)
n = int(input())
for x in range(n):
    x=input().split()
    e[e.index(x[0])]=x[1]
    print(*e)