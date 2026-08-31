n,m=list(map(int,input().split()))
s=set()
for i in range(n):
    s.update(map(int,input().split()[1:]))
print('YES' if len(s)==m else 'NO')