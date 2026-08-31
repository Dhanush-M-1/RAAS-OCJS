from sys import stdin,stdout

def update(L,C,l,r,rt):
    if l==r:
        tree[rt]+=C
        return
    mid=(l+r)//2
    if L<=mid:
        update(L,C,l,mid,rt<<1)
    else:
        update(L,C,mid+1,r,rt<<1|1)
    tree[rt]=tree[rt<<1]+tree[rt<<1|1]

def query(s,l,r,rt):
    if l==r:
        return l
    mid=(l+r)//2
    if tree[rt<<1]>s:
        return query(s,l,mid,rt<<1)
    else:
        return query(s-tree[rt<<1],mid+1,r,rt<<1|1)

if __name__ == '__main__':
    tree=[0]*800005
    n=int(stdin.readline())
    a=list(map(int,stdin.readline().split()))
    for i in range(n):
        update(i+1,i+1,1,n,1)
    b=[0]*200005
    for i in range(n,0,-1):
        b[i]=query(a[i-1],1,n,1)
        update(b[i],-b[i],1,n,1)
    for i in range(n):
        stdout.write('%d '%(b[i+1]))