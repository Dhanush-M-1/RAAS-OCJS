n,m = map(int,input().split())
ls=[]
x = []
no=[]
B=[]
for i in range(1,m+1):
    B.append(i)
while(n):
     n-=1
     ls = list(map(int,input().split()))
     x.append(ls[0])
     for i in ls[1:]:
            no.append(i)
     
            
no = set(no)
no=list(no)
if(no==B):
    print('YES')
else:
    print('NO')
