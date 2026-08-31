n,k=map(int,input().split())
alice=[]
bob=[]
both=[]
a,b=0,0
al,bl,bol=0,0,0
for i in range(n):
    t,x,y=map(int,input().split())
    if x==1 and y==1:
        both.append(t)
        bol+=1
    elif x==1:
        alice.append(t)
        al+=1
    elif y==1:
        bob.append(t)
        bl+=1
alice.sort()
bob.sort()
both.sort()
ai,bi,boi=0,0,0
count=0
check=False
while ((ai<al and bi<bl) and boi<bol):
    if both[boi]<alice[ai]+bob[bi]:
        a+=1
        b+=1
        count+=both[boi]
        boi+=1
    else:
        count+=alice[ai]+bob[bi]
        ai+=1
        bi+=1
        a+=1
        b+=1
    if a>=k and b>=k:
        check=True
        break
if check:
    print(count)
else:
    if boi==bol:
        na=k-a
        if al-ai>=na:
            for i in range(max(na,0)):
                count+=alice[ai+i]
            nb=k-b
            if bl-bi>=nb:
                for i in range(max(nb,0)):
                    count+=bob[bi+i]
                print(count)
            else:
                print("-1")
        else:
            print('-1')
    elif ai==al:
        na=k-a
        if bol-boi>=na:
            for i in range(max(na,0)):
                count+=both[boi+i]
                b+=1
            nb=k-b
            if bl+bol-boi-bi>=nb:
                l=[]
                for i in range(boi,min(bol,boi+max(nb,0))):
                    l.append(both[i])
                for i in range(bi,min(bl,bi+max(nb,0))):
                    l.append(bob[i])
                l.sort()
                for i in range(max(nb,0)):
                    count+=l[i]
                print(count)
            else:
                print("-1")
        else:
            print("-1")
    else:
        nb=k-b
        if bol-boi>=nb:
            for i in range(max(nb,0)):
                count+=both[boi+i]
                a+=1
            na=k-a
            if al+bol-boi-ai>=na:
                l=[]
                for i in range(boi,min(bol,boi+max(na,0))):
                    l.append(both[i])
                for i in range(ai,min(al,ai+max(na,0))):
                    l.append(alice[i])
                l.sort()
                for i in range(max(na,0)):
                    count+=l[i]
                print(count)
            else:
                print("-1")
        else:
            print('-1')