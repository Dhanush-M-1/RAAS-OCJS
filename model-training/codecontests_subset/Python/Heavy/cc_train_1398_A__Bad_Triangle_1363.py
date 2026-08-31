t=int(input())
 
for _ in range(t):
    n=int(input())
    l=list(map(int,input().split()))
    maxx = max(l)
    minn = min(l)
    minn_ind = l.index(minn)
    minn2 = maxx
    
    for i in range(n):
        if i==minn_ind:
            continue
        if l[i]==minn:
            minn2 = minn 
            minn2_ind = i
            break 
        if l[i]<minn2:
            minn2 = l[i]
            minn2_ind = i
    
    if (minn+minn2)<=maxx:
        maxx_ind = l.index(maxx)
        temp = [minn_ind,minn2_ind,maxx_ind]
        temp.sort()
        for j in temp:
            print(j+1,end = ' ')
        print()
        continue 
 
    print("-1")
    
    