def combo(n,m,s,p):
    l=[chr(i) for i in range(ord("a"),ord("z")+1)]
    d={}
    for i in range(len(l)):
        d[l[i]]=0
    p.sort()
    i=0
    j=0
    for i in range(m):
        while j<p[i]:
            d[s[j]]+=(m-i)
            j+=1
    for i in range(n):
        d[s[i]]+=1
    print(*d.values())
t=int(input())
for i in range(t):
    n,m=map(int,input().split())
    s=input()
    p=list(map(int,input().split()))
    combo(n,m,s,p)            


# In[ ]:





# In[ ]:





# In[ ]:




