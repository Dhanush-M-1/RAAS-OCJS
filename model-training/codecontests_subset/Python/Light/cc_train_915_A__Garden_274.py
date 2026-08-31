n, k = map(int,input().split())
m = []
m1 = []

m = list(map(int,input().split()))

#print(m)

for i in range(n):
    if k % m[i]== 0:
        m1.append(k / m[i])
        
print(int(min(m1)))