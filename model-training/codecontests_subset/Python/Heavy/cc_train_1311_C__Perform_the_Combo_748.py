from collections import OrderedDict
for _ in range(int(input())):
    l,o=map(int,input().split());s=input();opr=list(map(int,input().split()))
    d=OrderedDict();d1=OrderedDict()
    for i in range(97,123):
        d[chr(i)]=0;d1[chr(i)]=0
    dp=[d]
    for i in s:
        t=dp[-1]
        t[i]+=1
        dp.append(t.copy())
    #print(dp) 
    for i in opr:
        t=dp[i-1]
        for j in range(97,123):
            d1[chr(j)]+=t[chr(j)]
    for i in s:
        d1[i]+=1
    for i in d1.values():
        print(i,end=' ')
    print()    
    
        
    
    