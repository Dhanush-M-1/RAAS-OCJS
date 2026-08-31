t=int(input())
for _ in range(t):
    n,m=[int(x) for x in input().split()] #n is the length of s, m is the length of p
    s=input()
    p=[int(x) for x in input().split()] #combo lengths

    prefixSums=[[0 for _ in range(n)] for __ in range(26)]
#    prefixSums[i][j-1] is the count of character i (i==0 is for 'a') for combo length of j
    for k in range(n):
        if k>0:
            for i in range(26):
                prefixSums[i][k]=prefixSums[i][k-1]
        prefixSums[ord(s[k])-ord('a')][k]+=1
    
    res=[0 for _ in range(26)]
    for l in p:
        for i in range(26):
            res[i]+=prefixSums[i][l-1]
    for i in range(26):
        res[i]+=prefixSums[i][n-1] #for the last (and successful) combo
    
    print(' '.join([str(x) for x in res]))