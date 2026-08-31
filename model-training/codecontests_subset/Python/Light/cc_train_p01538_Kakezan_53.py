# your code goes here
#times volume24 2424
Q=int(input())
for i in range(Q):
    N=str(input())
    c=0
    while len(N)>1 and c<15:
        M=0
        for j in range(1,len(N)):
    #        print(N[:j])
            l=int(N[:j])
            r=int(N[j:])
            l*=r
            if M<l:
                M=l
      #      print(M)
        N=str(M)
        c+=1
  #  print(N)
    if c>=15:
        d=[int(N)]
        while len(N)>1 and c>=0 and c<50:
            M=0
        #    print(d)
            for j in range(1,len(N)):
        #        print(N[:j])
                l=int(N[:j])
                r=int(N[j:])
                l*=r
                if M<l:
                    M=l
      #          print(M)
            k=0
            while k<len(d) and M>d[k]:
                k+=1
         #   print(k)
            if k>=len(d):
                k=-1
            elif M==d[k]:
                c=-1
            d.insert(k,M)
            N=str(M)
            c+=1
        #    print(k)
    print(c)