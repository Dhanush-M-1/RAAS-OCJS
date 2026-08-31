def cnt(n,b):
    ans=crumb=n 
    while crumb>=b:
        ans+=crumb//b
        crumb=crumb//b+crumb%b 
    return ans 
a,b=map(int,input().split())
print(cnt(a,b))