t=int(input())
while(t):
    t=t-1
    n=int(input())
    for i in range(n):
        s=input()
        if(i==0):
            ur=s[1]
        if(i==1):
            ud=s[0]
        if(i==n-2):
            du=s[-1]
        if(i==n-1):
            dl=s[-2]
    if(ur=='1' and ud=='1'):
        if(du=='0' and dl=='0'):
            print(0)
            continue
        elif(du=='1' and dl=='1'):
            print(2)
            print(n-1,n)
            print(n,n-1)
            continue
        elif(du=='0' and dl=='1'):
            print(1)
            print(n,n-1)
            continue
        else:
            print(1)
            print(n-1,n)
            continue
    elif(ur=='0' and ud=='0'):
        if(du=='1' and dl=='1'):
            print(0)
            continue
        elif(du=='0' and dl=='0'):
            print(2)
            print(n-1,n)
            print(n,n-1)
            continue
        elif(du=='0' and dl=='1'):
            print(1)
            print(n-1,n)
            continue
        else:
            print(1)
            print(n,n-1)
            continue
    elif(ur=='0' and ud=='1'):
        if(du=='1' and dl=='1'):
            print(1)
            print(2,1)
            continue
        elif(du=='0' and dl=='0'):
            print(1)
            print(1,2)
            continue
        elif(du=='0' and dl=='1'):
            print(2)
            print(1,2)
            print(n,n-1)
            continue
        else:
            print(2)
            print(1,2)
            print(n-1,n)
            continue
    else:
        # ur = 1  ud = 0
        if(du=='1' and dl=='1'):
            print(1)
            print(1,2)
            continue
        elif(du=='0' and dl=='0'):
            print(1)
            print(2,1)
            continue
        elif(du=='0' and dl=='1'):
            print(2)
            print(1,2)
            print(n-1,n)
            continue
        else:
            print(2)
            print(1,2)
            print(n,n-1)
            continue