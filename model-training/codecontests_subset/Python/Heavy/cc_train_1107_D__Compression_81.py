n=int(input())
l=[(format(int(input(),16),"b").zfill(n)) for i in range(n)]

row=[]
col=[]
def cm(j):
    for i in range(n):
        if l[i][j-1]!=l[i][j]:
            return False
    return True

def gcd(a,b):
    while b:
        a,b=b,a%b
    return a    
          
cnt=1    
for i in range(1,n):
    if l[i]==l[i-1]:
        cnt+=1
    else:
        row.append(cnt)
        cnt=1
        
row.append(cnt)
cnt=1
for j in range(1,n):
    if cm(j):
        cnt+=1
    else:
        col.append(cnt)
        cnt=1
col.append(cnt) 

ans=col[0]
for i in (row+col):
    ans=gcd(i,ans)
print(ans)    