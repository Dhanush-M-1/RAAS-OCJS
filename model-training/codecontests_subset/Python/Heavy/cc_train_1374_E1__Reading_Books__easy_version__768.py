n,k=[int(j) for j in input().split()]
al=bo=0
both=[]
sial=[]
sibob=[]
for i in range(n):
    tim,alice,bob=[int(j) for j in input().split()]
    if(alice==1 and bob==1):
        both.append(tim);
        al+=1
        bo+=1
    elif(alice ==1):
        sial.append(tim)
        al+=1
    elif(bob == 1):
        sibob.append(tim)
        bo+=1
    
if(al<k or bo<k):
    print(-1)
else:
    both.sort()
    sial.sort()
    sibob.sort()
    bsize=bosize=alsize=count=ans=cntboth=cntsial=cntsibob=0
    bsize = len(both)
    alsize=len(sial)
    bosize = len(sibob)
    while(count != k):
        if(cntboth<bsize and cntsial<alsize and cntboth<bosize):
            if(both[cntboth] <= (sial[cntsial]+sibob[cntsibob]) ):
                ans += both[cntboth]
                cntboth+=1
            else:
                ans += (sial[cntsial]+sibob[cntsibob])
                cntsial+=1 
                cntsibob+=1
        elif(cntboth>=bsize and cntsial<alsize and cntsibob<bosize):
            ans += (sial[cntsial]+sibob[cntsibob])
            cntsial+=1
            cntsibob+=1
        elif( cntboth<bsize and (cntsial>=alsize or cntboth>=bosize) ):
            ans += both[cntboth]
            cntboth+=1
        count+=1
    print(ans)