t=int(input())
l=['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
for r in range(t):
    n,m=map(int,input().split())
    s=input()
    p=list(map(int,input().split()))
    freq={}
    for i in s:
        try:
            if freq[i]>0:
                freq[i]+=1
        except:
            freq[i]=1
    d={}
    for i in freq:
        d[i]=[]
    for i in d:
        if s[0]==i:
            d[i].append(1)
        else:
            d[i].append(0)
        for j in range(1,n):
            if s[j]==i:
                d[i].append(d[i][j-1]+1)
            else:
                d[i].append(d[i][j-1])
    for i in p:
        for j in d:
            freq[j]+=d[j][i-1]
    for i in l:
        try:
            if freq[i]>0:
                print(freq[i],end=" ")
        except:
            print(0,end=" ")
    print()

            
