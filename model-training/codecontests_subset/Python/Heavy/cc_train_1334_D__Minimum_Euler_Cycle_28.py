import sys
def data(): return sys.stdin.buffer.readline().strip()
out=sys.stdout.write
def mdata(): return map(int, data().split())

for t in range(int(data())):
    n,l,r=mdata()
    a=l
    for i in range(1,n+1):
        if 2*(n-i)<=a:
            a-=2*(n-i)
        else:
            break
    cnt=l
    ans=[]
    if l%2==0:
        if a==0:
            ans.append(str(n))
        else:
            ans.append(str(i+a//2))
        cnt+=1
    k=i+a//2+1
    for j in range(i,n):
        while cnt<=r:
            ans.append(str(j))
            cnt+=1
            if cnt>r:
                break
            ans.append(str(k))
            k+=1
            cnt+=1
            if k==n+1:
                k=j+2
                break
    if r==n*(n-1)+1:
        ans.append(str(1))
    out(' '.join(ans)+'\n')

