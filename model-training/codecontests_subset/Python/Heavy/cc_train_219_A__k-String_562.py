k=int(input())

a=input()

d={}
l=[]
flag=0

length=len(a)
if length%k!=0:
    #print("kamhoise 1")
    print(-1)
else:
    s=""
    t=""
    j=int(length/k)
    #print("j",j)
    for i in range(length):
        if a[i] not in l:
            l.append(a[i])
            d[a[i]]=1
        else:
            d[a[i]]+=1

    for i in range(len(l)):
        if d[l[i]]%k!=0:
            flag=1
            break
        else:
            for j in range(int(d[l[i]]/k)):
                s=s+l[i]
    #print(s)
    for i in range(k):
        t=t+s
    if flag==1:
        print(-1)
    else:
        print(t)
