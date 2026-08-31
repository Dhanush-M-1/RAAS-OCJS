# x = int(input())
# m, n = map(int, input().split())
# nums = list(map(int, input().split()))
n=int(input())
while n!=0:
    n-=1
    a,b=map(list,input().split())
    la=len(a);lb=len(b)
    for i in range(la):
        p=i
        for j in range(la-1,i,-1):
            if a[j]<a[p]:
                p=j
        if p!=i:
             a[i],a[p]=a[p],a[i]
             break
    if a<b:
        la=len(a)
        for i in range(la):
            print(a[i],end='')
        print()
    else:
        print('---')

  		 					 	       					 	 		 	