# coding: utf-8
# Your code here!
N=int(input())

for n in range(N):
    a,b=(input().split(" "))
    al=list(a)
    bl=list(b)
    
    al_org=al[:]
    al.sort()
    N=len(al)
    flag=False
    for i in range(N):
        if al[i]!=a[i]:
            temp="Z"
            pot=-1
            for j in range(i,N)[::-1]:
                flag=True
                if temp>a[j]:
                    pot=j
                    temp=a[j]
        if flag:
            al_org[i],al_org[pot]=al_org[pot],al_org[i]
            break
    #print(al_org,bl)
    if "".join(al_org)<"".join(bl):
        print("".join(al_org))
    else:
        print("---")
