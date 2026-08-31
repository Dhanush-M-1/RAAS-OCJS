from sys import stdin
from math import log
"""
n=int(stdin.readline().strip())
n,m=map(int,stdin.readline().strip().split())
s=list(map(int,stdin.readline().strip().split()))
"""
p6=[]
if True:
    st=set()
    for i in range(30):
        p6.append(6**i)
        st.add(6**i)
    aux=[]
    for i in st:
        for j in range(30):
            if i%(2**j)==0:
                aux.append(i//(2**j))
    for i in aux:
        st.add(i)
st=list(st)
T=int(stdin.readline().strip())
for caso in range(T):
    x=int(stdin.readline().strip())
    ans=0
    if x in st:
        while x not in p6:
            x*=2
            ans+=1
        print(int(ans+log(x,6)))
    else:
        print(-1)


