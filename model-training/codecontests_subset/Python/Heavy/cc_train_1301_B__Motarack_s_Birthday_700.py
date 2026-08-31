"""T=int(input())
for _ in range(0,T):
    N=int(input())
    a,b=map(int,input().split())
    s=input()
    s=[int(x) for x in input().split()]
    for i in range(0,len(s)):
        a,b=map(int,input().split())"""


T=int(input())
for _ in range(0,T):
    N=int(input())
    s=[int(x) for x in input().split()]

    L=[]
    for i in range(0,len(s)):
        if(s[i]==-1):
            if(i-1>=0 and i-1<len(s)):
                if(s[i-1]!=-1):
                    L.append(s[i-1])

            if(i+1>=0 and i+1<len(s)):
                if(s[i+1]!=-1):
                    L.append(s[i+1])

    

    if(len(L)==0):
        print(0,0)
    else:
        L=list(set(L))
        tot=min(L)+max(L)

        ele1=tot//2
        ele2=tot//2
        if(tot%2!=0):
            ele2+=1

        L1=[]
        L2=[]
        for i in range(0,len(s)):
            if(s[i]==-1):
                L1.append(ele1)
                L2.append(ele2)
            else:
                L1.append(s[i])
                L2.append(s[i])

        #print(L1,L2)

        mx1=0
        mx2=0
        for i in range(0,len(s)-1):
            mx1=max(mx1,abs(L1[i]-L1[i+1]))
            mx2=max(mx2,abs(L2[i]-L2[i+1]))

        if(mx1<=mx2):
            print(mx1,ele1)
        else:
            print(mx2,ele2)
                
            

            
