t=int(input(""))
for i in range(t):
    la=int(input(""))
    l=[0,1]
    a=[int(x) for x in input("").split()]
    ai=a[0]
    aj=a[1]
    for i in range(2,la):
        if ai+aj<=a[i]:
            l.append(a.index(a[i]))
            for k in l:
                print(k+1,end=' ')
            print()
            break
    else:
        print(-1)
    


    


            
    
