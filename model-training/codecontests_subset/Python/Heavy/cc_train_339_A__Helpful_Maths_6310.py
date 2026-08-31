try:
    n=input()
    flag=0
    if(n.find('1')>-1):
        x=0
        x=n.count('1')
        if(x>=1):
            print('1',end="")
            flag=1
            x-=1
        while(x):
            print('+1',end="")
            x-=1 
    if(n.find('2')>-1):
        x=0
        x=n.count('2')
        if(x>=1 and flag==0):
            print('2',end="")
            flag=1
            x-=1
        while(x):
            print('+2',end="")
            x-=1 
    if(n.find('3')>-1):
        x=0
        x=n.count('3')
        if(x>=1 and flag==0):
            print('3',end="")
            flag=1
            x-=1
        while(x):
            print('+3',end="")
            x-=1        
    
except:
    pass
