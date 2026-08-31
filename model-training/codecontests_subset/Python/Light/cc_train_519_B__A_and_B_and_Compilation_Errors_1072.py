n=int(input())
e=list(map(int,input().split()))
c1=list(map(int,input().split()))
c2=list(map(int,input().split()))
e.sort()
c1.sort()
c2.sort()
c=0
d=0
for i in range(n-1):
    if(e[i]!=c1[i]):
        c=1
        print(e[i])
        break
if(c==0):
    print(e[n-1])
for j in range(n-2):
    if (c1[j] != c2[j]):
        d = 1
        print(c1[j])
        break
if (d == 0):
    print(c1[n-2])