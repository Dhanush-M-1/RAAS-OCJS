n,k=map(int,input().split())
#print(n,k)
a=list(map(int,input().split(' ')))
ans=100000000
for i in range(len(a)):
    #print(k/a[i])
    if k%int(a[i])==0 and ans>int(k)//int(a[i]):
        ans=k//(int(a[i]))
print(ans)
