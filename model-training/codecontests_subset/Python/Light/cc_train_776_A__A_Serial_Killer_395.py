def printlist(a):
    print(" ".join(a))

a = input().split()
printlist(a)

n=int(input())

for _ in range(n):
    x,y = map(str, input().split())
    i = a.index(x)
    a[i] = y
    printlist(a)
