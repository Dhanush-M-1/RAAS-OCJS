import io,os
input=io.BytesIO(os.read(0,os.fstat(0).st_size)).readline
import sys

def query(n,l,r):
    begin=1
    while l>(n-begin)*2+1:
        if begin==n:
            break
        l-=(n-begin)*2
        r-=(n-begin)*2
        begin+=1
    Ans=[]
    ans_l=0
    while ans_l<=r:
        if begin==n:
            Ans.append(1)
            break
        for j in range(begin+1,n+1):
            Ans.append(begin)
            Ans.append(j)
        ans_l+=(n-begin)*2
        begin+=1
    return Ans[l-1:r]

def main():
    t=int(input())
    for _ in range(t):
        n,l,r=map(int,input().split())
        Ans=query(n,l,r)
        sys.stdout.write(' '.join(map(str,Ans))+'\n')

if __name__=='__main__':
    main()