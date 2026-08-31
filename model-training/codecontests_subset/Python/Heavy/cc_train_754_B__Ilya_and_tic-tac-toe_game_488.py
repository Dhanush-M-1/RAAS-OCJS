L=[input() for i in range(4)]
yes=0
for i in range(4):
    for j in range(4):        
        c=L[i][j]
        b1=L[i+1][j] if i+1<4 else ''
        b2=L[i+2][j] if i+2<4 else ''
        l1=L[i][j+1] if j+1<4 else ''
        l2=L[i][j+2] if j+2<4 else ''
        d1=L[i+1][j+1] if i+1<4 and j+1<4 else ''
        d2=L[i+2][j+2] if i+2<4 and j+2<4 else ''
        k1=L[i+1][j-1] if i+1<4 and j-1>=0 else ''
        k2=L[i+2][j-2] if i+2<4 and j-2>=0 else ''
        R=[c,l1,l2];C=[c,b1,b2];D=[c,d1,d2];K=[c,k1,k2]
        ans=[(X.count('x')==2 and X.count('.')==1) for X in [R,C,D,K]]
        if any(ans):
            yes=1
            break
    if yes: break
print(['NO','YES'][yes])