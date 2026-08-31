from bisect import bisect_left as bl
from bisect import bisect_right as br
rr=['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
ss=[]
for jjij in range(int(input())):
    q={}
    n,m=map(int,input().split( ))
    s=input()
    p=sorted(list(map(int,input().split( ))))
    for i in range(n):
        q[s[i]]=q.get(s[i],0)+(m-bl(p,i+1))
    for i in q:
        q[i]+=s.count(i)
    f=[]
    for i in rr:
        f.append(q.get(i,0))
    ss.append(f)
for i in ss:
    for j in i:
        print(j,end=' ')
    print()
