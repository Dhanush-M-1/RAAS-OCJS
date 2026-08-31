for t in range(int(input())):
    a,b,c=list(map(int,input().split()))
    s1=0
    a1,b1,c1=a,b,c
    if a1>=(b1//2):
        s1+=((b1//2)+(2*(b1//2)))
        b1-=(2*(b1//2))   #-(b1//2)
    else:
        if a1>0:
            s1+=(a1+(2*a1))
            b1-=(2*a1)
    if b1>=(c1//2):
        s1+=((c1//2)+(2*(c1//2)))
    else:
        if b1>0:
            s1+=(b1+(2*b1))
    
    a2,b2,c2=a,b,c
    s2=0
    if b2>=(c2//2):
        s2+=((c2//2)+(2*(c2//2)))
        b2-=(c2//2)
    else:
        if b2>0:
            s2+=(b2+(2*b2))
            b2-=b2
    if a2>=(b2//2):
        s2+=((b2//2)+(2*(b2//2)))
        
    else:
        if a2>0:
            s2+=3*a2
    print(max(s1,s2))
        
        
    