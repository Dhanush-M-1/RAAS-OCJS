import math
######################################################
# ps template
def mi(): return map(int, input().split())
def ii(): return int(input())
def li(): return list(map(int, input().split()))
def si(): return input().split()

#######################################################
t = ii()
for _ in range(t):
    n, m = mi()
    a = li()
    b = li()
    dic_a = {}
    for i in range(n):
        if dic_a.get(a[i]):
            dic_a[a[i]]+=1
        else:
            dic_a[a[i]] = 1
    for i in range(m):
        if dic_a.get(b[i]):
            print("YES")
            print(1,b[i])
            break
    else:
        print("NO")