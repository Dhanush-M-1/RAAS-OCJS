import string

def combo(m,s):
    s1=string.ascii_lowercase
    
    l=[0 for i in range(len(s))]
    
    for i in range(len(m)):
        l[m[i]-1]+=1
        
    i=len(s)-1
    while i>0 :
        l[i-1]+=l[i]
        i-=1
    d={}
    for i in range(len(s)):
        if not d.get(s[i]):
            d[s[i]]=l[i]+1
        else:
            d[s[i]]+=l[i]+1
    
    
    l1=[]
    for e in s1:
        if d.get(e):
            l1.append(d[e])
        else:
            l1.append(0)
        
    return ' '.join(map(str,l1))
        
    
    



for i in range(int(input())):
    a,b=map(int,input().split())
    s=input()
    m=list(map(int,input().split()))
    print(combo(m,s))
        