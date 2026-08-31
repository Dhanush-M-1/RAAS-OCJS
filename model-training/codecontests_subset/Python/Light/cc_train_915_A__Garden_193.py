n, k = map(int,input().split())
l = [*map(int,input().split())]
Min = float('inf')
for i in range(n-1,-1,-1):
    if k%l[i]==0 and k//l[i] < Min:
        Min=k//l[i]
print(Min)