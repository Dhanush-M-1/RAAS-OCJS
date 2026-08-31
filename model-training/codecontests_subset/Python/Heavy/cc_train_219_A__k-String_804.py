k=int(input())
s=input()
l=len(s)
dic={}
for i in range(l):
    if s[i] in dic:
        dic[s[i]]+=1
    else:
        dic[s[i]]=1
if l%k==0:
    d=l//k
    se=set(s)
    if len(se)>d:
        print(-1)
    else:
        boo=True
        for i in dic:
            if dic[i]%k!=0:
                print(-1)
                boo=False
                break
        if boo:
            ans=""
            for i in dic:
                for j in range(dic[i]//k):
                    ans=ans+i
            for i in range(k):
                print(ans,end='')
else:
    print(-1)
