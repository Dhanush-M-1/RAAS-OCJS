def kString():
    k=int(input())
    s=input()
    size=len(s)
    d={}
    ans=''
    if size%k!=0:
        print(-1)
        return
    else:
        for i in range(size):
            d[s[i]]=0
        for i in range(size):
            d[s[i]]=d[s[i]]+1
        for i in d.keys():
            if d[i]%k!=0:
                print(-1)
                return
        for i in range(k):
            for j in d.keys():
                ans=ans+((d[j]//k)*j)
        print(ans)
        return

kString()























