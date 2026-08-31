import sys
num = int(input())
deg = [0]*(num+1)
for _ in range(1,num):
    a, b = [int(i) for i in input().split()]
    deg[a ] += 1
    deg[b] += 1
for i in range(1, num+1):
    if deg[i] == 2:
        print("NO")
        sys.exit()
print("YES")