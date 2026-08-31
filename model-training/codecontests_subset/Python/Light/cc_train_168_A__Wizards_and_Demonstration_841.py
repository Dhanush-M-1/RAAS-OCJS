n,w,c = map(int,input().split())
k = (c*n)/100
if int(k)!=k:
    k = int(k)+1
print(int(k)-w if(int(k)-w)>0 else 0)

