def ans(a, n):
    s1 = a[0][1]
    s2 = a[1][0]

    f2 = a[n-1][n-2]
    f1 = a[n-2][n-1]

    if f1==f2 and s1==s2 and f1!=s1:
        print(0) #correct

    elif f1==f2 and f1==s1 and s1==s2:
        print(2)
        #change s1 and s2

        print('1 2')
        print('2 1') #correct

    
    elif f1==f2:
        print(1)
        if s1==f1:
            #change s1
            print('1 2')
            
        else:
            #change s2
            print('2 1')

    elif s1==s2:
        print(1)
        if f2==s1:
            #change f2
            print(str(n)+' '+str(n-1))

        else:
            #change f1
            print(str(n-1)+' '+str(n))

    else:
        #change s1
        print(2)
        if f1==s1:
            #change s1 and f2
            print('1 2')
            print(str(n)+' '+str(n-1))

        else:
            #change s1 and f1
            print('1 2')
            print(str(n-1)+' '+str(n))
    

    return
    
m = int(input())

for j in range(m):
    n = int(input())
    a = []
    for i in range(n):
        b = input()
        a.append(b)
        
    ans(a, n)
