n, k = map(int,input().split())
l = [*map(int,input().split())]
l.sort()
for i in range(n-1,-1,-1):
    if k%l[i]==0:
        print(k//l[i])
        break