n=int(input())
a=[0]*n
for i in range(n-1):
    c,d=map(int,input().split())
    a[c-1]+=1
    a[d-1]+=1
stat=2 in a
if(stat):
    print('NO')
else:
    print('YES')