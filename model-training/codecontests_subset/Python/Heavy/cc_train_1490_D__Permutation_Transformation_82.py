def func(l,r,x):
    global a
    global level
    if(l<r):
     inde=-1
     for  i in range(l,r+1):
        if(a[i]!=x):
            level[i]+=1
        else:
            inde=i
     #print(l,r,inde)
     if(inde==l):
         func(l+1,r,max(a[l+1:r+1]))
     elif(inde==r):
         func(l,r-1,max(a[l:r]))
     else:
      x1=max(a[l:inde])
      x2=max(a[inde+1:r+1])
      func(l,inde-1,x1)
      func(inde+1,r,x2)
    
    
for w in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    level=[0]*n 
    m=max(a)
    #inde = a.index(m)
    func(0,n-1,m)
    for i in range(n):
        print(level[i],end=" ")
    print()