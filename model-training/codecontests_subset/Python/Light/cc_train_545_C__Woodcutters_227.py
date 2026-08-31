n=int(input())
lst1=[]
lst2=[]
lst=[]
if n==1:
    a,b=input().split()
    print(1)
else:
    for i in range(n):
        a,b=input().split()
        lst1.append(int(a))
        lst2.append(int(b))
    for j in range(1,n):
        lst.append(lst1[j]-lst1[j-1])
    p=2
    u=0
    for r in range(n):
        if r==0 or r==n-1:
            pass
        else:
            if lst[r-1]>lst2[r]+u:
                p+=1
                u=0
            else:
                if lst[r]>lst2[r]:
                    p+=1
                    u=lst2[r]
                else:
                    u=0

    print(p)
