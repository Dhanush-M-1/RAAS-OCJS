def answer():
    n=int(input())
    a=[]
    for i in range(n):
        z=input()
        a.append([x for x in str(z)])
    b1={a[0][1],a[1][0]}
    b2={a[n-1][n-2],a[n-2][n-1]}
    c=b1&b2
    if (len(c)==0):
        print('0')
        return
    else:
        
        if len(c)==1:
            if int(a[0][1])^int(a[1][0]):
                if int(a[0][1])^int(a[n-1][n-2]):
                    print(len(c))
                    print("2 1")
                    return
                else:
                    print(len(c))
                    print("1 2")
                    return
            if int(a[n-1][n-2])^int(a[n-2][n-1]):
                if int(a[0][1])^int(a[n-1][n-2]):
                    print(len(c))
                    print(n-1,n)
                    return
                else:
                    print(len(c))
                    print(n,n-1)
                    return
            if(int(a[0][1])==int(a[1][0])):
                print(len(c)+1)
                print('1 2')
                print('2 1')
                return
        if len(c)==2:
            if  int(a[0][1])^int(a[1][0]):
                if int(a[0][1])^int(a[n-1][n-2]):
                    print(len(c))
                    print("1 2")
                    print(n,n-1)
                    return
                else:
                    print(len(c))
                    print("1 2") #never do this kindof mistake,...keepin' ans extra comma in the previous submission
                    print(n-1,n)
                    return


test=int(input())
i=0
while (i<test):
    answer()
    i+=1