nt=int(input())
for qz in range(nt):
    n=int(input())
    a=list(map(int,input().split()))
    ans="inc"
    i=0
    flag=0
    var=-1
    while(ans=="inc" and i<n):
        if(a[i]<i):
            ans="dec"
            flag=1
            if(a[i-1]-a[i]<=1):
                a[i]=a[i-1]-1
            break
        i+=1
    
    
    while(i<n):
        if(a[i]<(n-i-1)):
            print("No")
            flag=2
            break
        i+=1
  #  if(var>0):
   #     if(a[var]==a[var-1] and a[var]>=(n-var-1) and a[var-1]>=(var-1)):
     #       print("No")
     #       flag=2
    if(flag!=2):
        print("Yes")