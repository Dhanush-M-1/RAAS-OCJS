n=int(input())
p=input()
if '8' in p:
    s=p.count('8')
    u=n-s
    t=0
    q=u//10
    o=0
    if q>=s:
        o+=s
    else:
        o+=q
        s-=q
        t+=1
    if s>=11:
        o+=s//11
    if t>0:
        s-=(s//11)*11
        o+=(u%10+s)//11
    print(o)
else:
    print(0)
    
