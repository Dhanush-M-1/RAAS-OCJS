x=int(input())
y=input()
if(x==1):
    print(1)
    print(y)
elif((x%2)==0):
    ylist=list(y)
    sum0=ylist.count('0')
    sum1=ylist.count('1')
    if(sum1!=sum0):
        print(1)
        print(y)
    elif(((x/2)%2)==1):
        print(2)
        print((''.join(ylist[0:int(x/2)]))+' '+''.join(ylist[int(x/2):x]))
    elif( ((x/2)%2)==0):
        print(2)
        print(''.join(ylist[0:(int(x/2)+1)])+' '+''.join(ylist[(int(x/2)+1):x])) 
        
elif((x%2)==1):
    print(1)
    print(y)
            