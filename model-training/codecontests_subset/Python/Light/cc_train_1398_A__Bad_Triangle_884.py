def ans(a,n):
    i = 1
    j = 2
    k = n
    if a[i-1]+a[j-1]>a[k-1]:
        print(-1)
    else:
        print(str(i)+' ' +str(j)+' '+str(k))
        
 
m = int(input())
for i in range(m):
    n = int(input())
    arr = input().split()
 
    a = []
    for i in arr:
        a.append(int(i))
 
    ans(a,n)
