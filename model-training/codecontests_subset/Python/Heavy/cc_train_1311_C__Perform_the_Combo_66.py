for _ in range(int(input())):
    n,m =  map(int,input().split())
    ss = list(input())
    pos = sorted(map(int,input().split()))+[n]
    fre=[0]*(26)
    tot=[0]*26
    ti=[0]*26
    las=0
    for i in range(m+1):
        k=pos[i]
        for j in range(las,k):
            ti[ord(ss[j])-ord('a')]+=1
        for j in range(26):
            tot[j]+=ti[j]
        for j in range(26):
            fre[j]+=tot[j]
        ti=[0]*26        
        las=pos[i]            
    print(*fre)    

        

