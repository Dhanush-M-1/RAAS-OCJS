import io,os
input=io.BytesIO(os.read(0,os.fstat(0).st_size)).readline
import sys

def solve(n,k,TAB):
    A,B,AB=[],[],[]
    cnt_a,cnt_b=0,0
    for t,a,b in TAB:
        cnt_a+=a; cnt_b+=b
        if a*b==1:
            AB.append(t)
        elif a==1:
            A.append(t)
        elif b==1:
            B.append(t)
    if cnt_a<k or cnt_b<k:
        return -1
    AB.sort(); A.sort(); B.sort()
    AB=AB[:min(k,len(AB))]
    l=len(AB)
    remain=k-l
    ans=sum(AB)+sum(A[:remain])+sum(B[:remain])
    tmp=ans
    for i in range(min(l,len(A)-remain,len(B)-remain)):
        tmp-=AB.pop()
        tmp+=A[remain+i]+B[remain+i]
        ans=min(ans,tmp)
    return ans

def main():
    n,k=map(int,input().split())
    TAB=[list(map(int,input().split())) for _ in range(n)]
    ans=solve(n,k,TAB)
    sys.stdout.write(str(ans)+'\n')
    
if __name__=='__main__':
    main()