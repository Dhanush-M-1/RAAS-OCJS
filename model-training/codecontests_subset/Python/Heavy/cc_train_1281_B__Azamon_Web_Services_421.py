for i in ' '*int(input()):
    s,c=input().split()
    if s<c:
        print(s)
        continue
    L=list(s)
    sL=sorted(L)
    if L==sL:
        if s<c:print(s)
        else:print('---')
    else:
        k=0
        for i in range(len(s)-1):
            if L[i]!=sL[i]:
                k=i
                break
        m='Z'
        count=0
        for j in range(i, len(s)):
            if L[j]<=m:
                m=L[j]
                count=j
        L[count],L[i]=L[i],L[count]
        ss=''
        for i in L:ss+=i
        if ss<c:print(ss)
        else:print('---')