p = 0
n , m = map(int,input().split())
unc = 0
uc = n
for i in range(1000):
    p += uc
    unc += uc
    uc = unc//m
    unc = unc - (uc*m)
    
    
print(p)
