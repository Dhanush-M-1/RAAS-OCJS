n,k = map(int,input().split())
L = input().split()
m = 101
for a in L:
    a = int(a)
    if k % a == 0:
        r = k//a
        if r < m:
            m = r
print (m)
