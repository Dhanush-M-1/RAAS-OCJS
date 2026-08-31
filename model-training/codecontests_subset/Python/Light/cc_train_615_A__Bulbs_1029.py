bt , bu = map(int,input().split())
b = []
for i in range(bt) :
    a = list(map(int,input().split()))
    b += a[1:]
b = set(b)
if(len(b)==bu) :
    print('YES')
else :
    print('NO')
