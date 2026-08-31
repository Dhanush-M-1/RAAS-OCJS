n=int(input())
for q in range(n):
    j,k,l=list(map(int,input().split()))
    if j>l:
        print(l)
    else:
        d=k//l
        s=l*d   
      #  print(d)
        while s<k:
            s+=l
        if s==k:
            s+=l
        print(s)    
