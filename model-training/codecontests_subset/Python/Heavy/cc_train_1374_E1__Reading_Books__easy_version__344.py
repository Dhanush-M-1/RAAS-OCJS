n,k = [int(x) for x in input().split()]
at = []
bt = []
ct = []
for i in range(n):
    ti,ai,bi = [int(x) for x in input().split()]
    if ai == 1 and bi == 1:
        ct.append(ti)
    elif ai == 1:
        at.append(ti)
    elif bi == 1:
        bt.append(ti)
    else:
        continue
if len(ct)+len(at)<k or len(ct)+len(bt)<k:
    print(-1)
else:
    ci = 0
    ai = 0
    # bi = 0
    al = k
    # bl = k
    ans = 0
    ct.sort()
    at.sort()
    bt.sort()
    # for i in range(len(ct)):
    i=0
    # print(at,bt,ct)
    while(i<len(ct) and al>0 and ai<min(len(at),len(bt))):
        if ct[i]<at[ai]+bt[ai]:
            ans+=ct[i]
            # al-=1
            i+=1
        else:
            ans+=at[ai]+bt[ai]
            # al-=1
            ai+=1
        al-=1
        # print(i,ai,ans)
        
    if (i==len(ct) and al!=0):
        bl = al
        ans+=sum(at[ai:ai+al])+sum(bt[ai:ai+al])
    elif(ai == min(len(at),len(bt)) and al>0):
        ans+=sum(ct[i:i+al])
    print(ans)
    # if len(ct)>=k:
        # ct.sort()
        # print(sum(ct[:k]))
    # else:
        # aleft = k - len(ct)
        # bleft = k - len(ct)
        # ans = sum(ct)
        # at.sort()
        # bt.sort()
        # ans+=sum(at[:aleft])+sum(bt[:bleft])
        # print(ans)