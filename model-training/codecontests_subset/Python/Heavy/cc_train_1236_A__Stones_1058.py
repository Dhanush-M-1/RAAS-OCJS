t=int(input())
for i in range(t):
    x,y,z=map(int,input().split())
    if((x>=1 and y>=2)or(y>=1 and z>=2)):
        z=int(z/2)
        temp = y-z
        if(temp>=2):
            #k = 3*z
            y = int(temp/2)
            k = x-y
            if(k>=0):
                ans=(3*z)+(3*y)
                print(ans)
            else:
                ans=(3*z)+(3*x)
                print(ans)
                
        elif(temp>=0):
            print((3*z),end='\n')
        else:
            print((3*y),end='\n')
    else:
        print("0",end='\n')