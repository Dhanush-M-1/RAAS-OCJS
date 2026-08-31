import sys,io,os
from collections import deque
try:Z=io.BytesIO(os.read(0,os.fstat(0).st_size)).readline
except:Z=lambda:sys.stdin.readline().encode()
Y=lambda:map(int,Z().split())
M=10**9+7
n,N=Y()
def path(R):
    H=deque();H.append(R)
    while P[R]>=0:
        R=P[R];H.append(R)
        if len(H)>2:P[H.popleft()]=H[-1]
    return R
K=[-1]*N;P=[-1]*N;S=[1]*N;R=0;B=[];alr=[0]*N
for i in range(n):
    k=*Y(),
    if k[0]<2:
        a=k[1]-1
        if K[a]>=0:
            v=path(K[a])
            if not alr[v]:alr[v]=1
            else:continue
        else:K[a]=R;v=R;alr[R]=1;R+=1
        B.append(i+1)
        continue
    a=k[1]-1;b=k[2]-1
    if K[a]>=0:
        if K[b]>=0:
            va,vb=path(K[a]),path(K[b])
            if va==vb or (alr[va] and alr[vb]):pass
            else:
                sa,sb=S[va],S[vb]
                if sa>sb:P[vb]=va
                else:
                    P[va]=vb
                    if sa==sb:S[vb]+=1
                B.append(i+1)
                if alr[va]:alr[vb]=1
                if alr[vb]:alr[va]=1
        else:K[b]=path(K[a]);B.append(i+1)
    else:
        if K[b]>=0:vb=K[a]=path(K[b]);B.append(i+1)
        else:K[a]=R;K[b]=R;R+=1;B.append(i+1)
B.sort()
s=len(B)
print(pow(2,s,M),s)
print(' '.join(map(str,B)))