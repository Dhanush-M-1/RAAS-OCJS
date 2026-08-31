n=input()
arr=[]
for i in range(int(n)):
    arr.append(list(map(int,input().split())))
for j in range(int(n)):
    x=0
    if int(arr[j][0])==1:
        print('0')
    elif int(arr[j][0])%6==0:
        while int(arr[j][0])%6==0:
            arr[j][0]=int(arr[j][0])/6
            x=x+1
            #print(x)
        if int(arr[j][0])%3==0:
            while int(arr[j][0])%3==0:
                arr[j][0]=int(arr[j][0])/3
                x=x+2
                #print(x)
            if int(arr[j][0])==1:
                print(x)
            else:
                print('-1')
        elif int(arr[j][0])==1:
            print(x)
        elif int(arr[j][0])%3!=0:
            print('-1')
    elif int(arr[j][0])%3==0:
        while int(arr[j][0])%3==0:
            arr[j][0]=int(arr[j][0])/3
            x=x+2
        if int(arr[j][0])==1:
            print(x)
        else:
            print('-1')
    else:
        print('-1')
                   
