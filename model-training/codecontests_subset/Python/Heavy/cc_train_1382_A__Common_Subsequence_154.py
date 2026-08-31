def readn():
    return int(input())
def readlist():
    return list(map(int,input().split()))
def readnos():
    return map(int,input().split())

for _ in range(int(input())):
    n,m = readnos()
    a = readlist()
    b = readlist()
    f = 1
    for i in range(n):
        for j in range(m):
            if a[i] == b[j]:
                f = 0
                break
        if f == 0:
            break
    if f == 0:
        print("YES")
        print(1, a[i], sep = ' ')
    else:
        print("NO")
    