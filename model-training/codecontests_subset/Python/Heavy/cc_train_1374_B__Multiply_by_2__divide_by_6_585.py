#rOkY
#FuCk

################################## kOpAl #######################################

def ans(a):
    count=0
    k=0
    while(a!=1):
        if(a%6==0):
            a=a//6
            count+=1
        else:
            a=a*2
            count+=1
            if(a%6!=0 or a==1):
                break

        if(a==1):
            k=1
            break
    if(k==1):
        print(count)
    else:
        print(-1)

t=int(input())
while(t>0):
    
    a=int(input())
    if(a==1):
        print(0)
    elif(a%10==5 or (a%6!=0 and (a*2)%6!=0)):
        print(-1)
    else:
        ans(a)
    t-=1
    
