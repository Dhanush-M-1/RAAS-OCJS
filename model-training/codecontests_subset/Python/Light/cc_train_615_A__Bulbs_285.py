#-------------Program--------------
#----Kuzlyaev-Nikita-Codeforces----
#-------------Training-------------
#----------------------------------

n,m=map(int,input().split())
a=[0]*m
for i in range(n):
    x=list(map(int,input().split()))
    for j in range(1,len(x)):
        a[x[j]-1]=1
if a.count(0)!=0:print('NO')
else:
    print('YES')