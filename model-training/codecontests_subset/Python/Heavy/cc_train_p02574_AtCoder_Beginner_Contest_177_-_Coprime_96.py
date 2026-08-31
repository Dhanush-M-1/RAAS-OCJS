import math
n=int(input())
a=list(map(int,input().split()))
table=[0 for i in range(10**6+7)]
flag=0
for i in a:
    table[i]+=1
    
for i in range(2,10**6+1):
    cnt=0
    j=i
    while(j<10**6+1):
        cnt+=table[j]
        j+=i
    if(cnt>1):
        flag=1
        break

if(flag==1):
    tmp=a[0]
    for i in range(1,n):
        tmp=math.gcd(tmp,a[i])
    if(tmp==1):
        flag=2



if(flag==0):
    print('pairwise coprime')
    
if(flag==1):
    print('not coprime')

if(flag==2):
    print('setwise coprime')