#bulbs
n,m=map(int,input().split())
l=[]
for i in range(n):
    k=[int(x) for x in input().split()]
    for j in range(k[0]):
        l.append(k[j+1])
print('YES' if set(l)==set(range(1,m+1)) else 'NO')