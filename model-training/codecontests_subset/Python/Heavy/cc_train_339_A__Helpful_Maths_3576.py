def func(a, b):
    for i in range (b):
        print(a, sep='', end='')
        if i!=b-1:
            print("+", sep='', end='')
    return 
    


str=input()
c1=c2=c3=0
for i in range(0, len(str), 2):
    if str[i]=='1':
        c1+=1
    elif str[i]=='2':
        c2+=1
    else:
        c3+=1
func(1, c1)

if c2>0 and c1>0:
    print("+", sep='', end='')
    
if c2==0 and c1>0 and c3>0:
    print("+", sep='', end='')    

func(2, c2)

if c3>0 and c2>0:
    print("+", sep='', end='')

func(3, c3)