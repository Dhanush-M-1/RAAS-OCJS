def fun(l1,l2):
    i,j=0,0
    l1.sort()
    l2.sort()
    while(j<len(l2) and l1[i]==l2[j]):
        i=i+1
        j=j+1
    return l1[i]
n=int(input())
l1=list(map(int,input().split()))
l2=list(map(int,input().split()))
l3=list(map(int,input().split()))
print(fun(l1,l2))
print(fun(l2,l3))