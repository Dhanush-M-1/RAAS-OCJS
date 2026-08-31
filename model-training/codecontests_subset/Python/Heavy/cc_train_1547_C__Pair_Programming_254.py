t=int(input())
q=input()
for q1 in range(t):
    a,b,q=map(int,input().split())
    lst=list(map(int,input().split()))
    lst1=list(map(int,input().split()))
    lst2=[]
    i=0
    j=0
    while(i<len(lst) and j<len(lst1)):
        if lst[i]==0:
            lst2.append(lst[i])
            a+=1
            i+=1
        elif lst1[j]==0:
            a+=1
            lst2.append(lst1[j])
            j+=1
        else:
            if lst[i]<=a:
                lst2.append(lst[i])
                i+=1
            elif lst1[j]<=a:
                lst2.append(lst1[j])
                j+=1
            else:
                break
    while(i<len(lst)):
        if lst[i]==0:
            a+=1
            lst2.append(lst[i])
        else:
            if a>=lst[i]:
                lst2.append(lst[i])
            else:
                break
        i+=1
    while(j<len(lst1)):
        if lst1[j]==0:
            a+=1
            lst2.append(lst1[j])
        else:
            if a>=lst1[j]:
                lst2.append(lst1[j])
            else:
                break
        j+=1
    if b+len(lst1)==len(lst2):
        print(*lst2)
    else:
        print(-1)
    if q1!=t-1:
        q=input()