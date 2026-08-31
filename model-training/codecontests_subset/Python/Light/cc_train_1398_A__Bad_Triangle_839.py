t=int(input(""))
for i in range(t):
    la=int(input(""))
    a=[int(x) for x in input("").split()]
    if a[0]+a[1]>a[-1]:
        print(-1)
    else:
        for i in range(2,la):
            if a[0]+a[1]<=a[i]:
                print(1,2,i+1)
                break

    


    


            
    
