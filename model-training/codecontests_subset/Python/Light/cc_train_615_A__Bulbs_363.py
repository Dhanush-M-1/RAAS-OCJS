n,m=map(int,input().split())
myBulb=[]
for i in range(n):
    arr=list(map(int,input().split()))
    myBulb+=arr[1:]

checkConn=True

for k in range(1,m+1):
    if(k not in myBulb):
        print('NO')
        checkConn=False
        break
if(checkConn==True):
    print('YES')


    