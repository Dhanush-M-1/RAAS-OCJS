def program():
    n=int(input())
    l=list(map(int, input().split()))
    l2=[]
    l3=[]
    for i in range(n):
        if l[i]==-1:
            if i==0:
                nex=l[1]
                prev=-1
            elif i==n-1:
                nex=-1
                prev=l[n-2]
            else:
                nex=l[i+1]
                prev=l[i-1]

            if nex!=-1 :
                l2.append(nex)
            if prev!=-1:
                l2.append(prev)

        else:
            if i==0:
                nex=l[1]
                prev=-1
            elif i==n-1:
                nex=-1
                prev=l[n-2]
            else:
                nex=l[i+1]
                prev=l[i-1]

            if nex!=-1:
                l3.append(abs(l[i]-nex))
            if prev!=-1:
                l3.append(abs(l[i]-prev))



    if len(l2)==0:
        print("0 0")
        return 0

    l2=set(l2)

    k=(max(l2)+min(l2))//2
    if len(l3)==0:
        m=max(l2)-k
    else:
        m=max(max(l3),max(l2)-k)

    print(m,k)

t=int(input())
for i in range(t):
    program()