n,k = map(int,input().split())
a = list(map(int,input().split()))
m = float('inf')
for i in a:
    if k%i == 0:
        m = min(m,k//i)
print(m)
