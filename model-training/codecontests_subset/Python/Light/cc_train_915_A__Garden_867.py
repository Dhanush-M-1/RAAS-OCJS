n,k=[int(x) for x in input().split()]
a=list(map(int,input().split()))
a.sort()
a.reverse()
mina=100000000000
for i in range(0,len(a)):
    if(k%a[i]==0):
        if(mina>(k//a[i])):
            mina=k//a[i]
print(mina)
        