"""T=int(input())
for _ in range(0,T):
    n=int(input())
    a,b=map(int,input().split())
    s=input()
    s=[int(x) for x in input().split()]
    for i in range(0,len(s)):
        a,b=map(int,input().split())"""



T=int(input())
for _ in range(0,T):
    n=int(input())
    s=input()
    ans=n
    for i in range(0,len(s)):
        if(s[i]=='>'):
            ans=min(ans,i)
            break
    c=0
    for i in range(len(s)-1,-1,-1):
        if(s[i]=='<'):
            ans=min(ans,c)
            break
        c+=1
    print(ans)
