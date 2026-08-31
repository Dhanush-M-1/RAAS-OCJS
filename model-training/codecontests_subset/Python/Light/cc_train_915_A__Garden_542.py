R=lambda:map(int,input().split())

n, k = R()

a = list(R())

ans = 0

for i in range(n):
    if k % a[i] == 0 and a[i] > ans: ans = a[i]
    
print(int(k / ans))
        