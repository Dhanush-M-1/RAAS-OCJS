n , k = map(int , input().split())
v = list(map(int , input().split()))
m = 0
for i in range(n) :
    if k % v[i] == 0 :
        m = max(m , v[i])
print(k // m)