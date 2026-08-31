n,m = map(int,input().split())
x = [i for i in range(1,m+1)]
l = []
for i in range(n):
    a = list(map(int,input().split()))
    b = [i for i in a[1:]]
    l+=b
l = list(set(l))
l.sort()
if(l==x):
    print('YES')
else:
    print('NO')