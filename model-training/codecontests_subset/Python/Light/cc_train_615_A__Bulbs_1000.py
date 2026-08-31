n,m=[int(x) for x in input().split()]
s=[]
for i in range(n):
    a=input().split()
    for j in range(1,len(a)):
        s.append(a[j])
for k in range(1,m+1):
    if str(k) not in s:
        print('NO')
        break
else:
    print('YES')