while True:
    n = int(input())
    if n == 0:
        break
    else:
        phlist=[]
        phflag=0
        for i in range(n):
            phlist.append(input())

        for i in range(len(phlist)-4):
            cur=0
            state=0
            for j in range(i, len(phlist)):
                s = phlist[j]
                cur+=len(s)
                if state==0 and cur<5:
                    continue
                elif state==0 and cur==5:
                    cur=0
                    state=1
                elif state==1 and cur<7:
                    continue
                elif state==1 and cur==7:
                    cur=0
                    state=2
                elif state==2 and cur<5:
                    continue
                elif state==2 and cur==5:
                    cur=0
                    state=3
                elif state==3 and cur<7:
                    continue
                elif state==3 and cur==7:
                    cur=0
                    state=4
                elif state==4 and cur<7:
                    continue
                elif state==4 and cur==7:
                    print(i+1)
                    phflag=1
                    break

            if phflag:
                break

