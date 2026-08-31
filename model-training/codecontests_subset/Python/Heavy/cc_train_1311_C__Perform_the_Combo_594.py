# cook your dish here
t=int(input())
while(t):
    n,m = map(int,input().split())
    s=input()
    #str=""
    l=list(map(int,input().split()))
    l.sort()
    a=[]
    val=[]
    a.append(m)
    val.append(l[0])
    for i in range(1,m):
        if(l[i]!=l[i-1]):
            a.append(m-i)
            val.append(l[i])
    c=[0]*26
    for i in s:
        c[ord(i)-97]+=1
    pos=0
    for i in range(len(val)):
        for j in range(pos,val[i]):
            c[ord(s[j])-97]=a[i]+c[ord(s[j])-97]
        pos=val[i]
    print(*c)
    t=t-1
        