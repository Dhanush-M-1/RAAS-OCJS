def check(l):
    for i,a1 in enumerate(l[:-2]):
        a2=l[i+1]
        s=a1+a2
        if s<=l[-1]:
            return [i,i+1,len(l)-1]
    return [-2]





t=int(input())
for i in range(t):
    n=int(input())
    l=input().split(' ')
    l=list(map(int,l))
    res=check(l)
    for m in res[:-1]:
        print(m+1,end=' ')

    print(res[-1]+1)






