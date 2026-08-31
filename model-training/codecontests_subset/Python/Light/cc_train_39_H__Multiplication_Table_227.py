n=int(input())
for i in range(1,n):
    for j in range(1,n):
        c=i*j
        d=[]
        while(c!=0):
            d.append(str(c%n))
            c=int(c/n)
        d.reverse()
    
        d="".join(d)
        print(d,end=" ")
    print()