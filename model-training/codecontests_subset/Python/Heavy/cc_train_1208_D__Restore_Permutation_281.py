from sys import stdin,stdout

class Tree(object):
    def __init__(self,n):
        self.tree=[0]*(4*n+10)
    def update(self,L,C,l,r,rt):
        if l==r:
            self.tree[rt]+=C
            return
        mid=(l+r)//2
        if L<=mid:
            self.update(L,C,l,mid,rt<<1)
        else:
            self.update(L,C,mid+1,r,rt<<1|1)
        self.tree[rt]=self.tree[rt<<1]+self.tree[rt<<1|1]


    def query(self,s,l,r,rt):
        if l==r:
            return l
        mid=(l+r)//2
        if self.tree[rt<<1]>s:
            return self.query(s,l,mid,rt<<1)
        else:
            return self.query(s-self.tree[rt<<1],mid+1,r,rt<<1|1)


if __name__ == '__main__':
    n=int(stdin.readline())
    a=list(map(int,stdin.readline().split()))
    b=[0]*(n+10)
    seg=Tree(n)
    for i in range(n):
        seg.update(i+1,i+1,1,n,1)
    for i in range(n,0,-1):
        b[i]=seg.query(a[i-1],1,n,1)
        seg.update(b[i],-b[i],1,n,1)
    for i in range(n):
        stdout.write('%d '%(b[i+1]))
    