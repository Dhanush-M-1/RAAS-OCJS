t=int(input())
for i in range(t):
    n,m=list(map(int,input().split()))
    s=input()
    p=list(map(int,input().split()))
    zeroarray=[0]*26
    aftereach=[[0]*26]*n
    psorted=sorted(list(set(p)))
    x=0
    final=[0]*26
    arr=zeroarray[:]
    for j in range(n):
        arr[ord(s[j])-97]+=1
        pos=psorted[x]
        if(pos==j+1):
            aftereach[pos]=arr[:]
            if(x+1<len(psorted)):
                x+=1
            else:
                break
    for j in range(n):
        final[ord(s[j])-97]+=1
    ans=[0]*26
    for j in p:
        for y in range(26):
            ans[y]=ans[y]+aftereach[j][y]
    for y in range(26):
        ans[y]=ans[y]+final[y]
    print(*ans)