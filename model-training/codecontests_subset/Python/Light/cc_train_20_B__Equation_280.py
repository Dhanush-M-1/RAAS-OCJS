a,b,c = map(int, input().split())
D = int(b*b - 4*a*c)
if a == 0 and b ==0 and c == 0:
    print(-1)
else:
    if D > 0 and a != 0:
        print(2)
        if -(b+D**0.5)/(2*a) < -(b-D*00.5)/(2*a):
            print(-(b+D**0.5)/(2*a))
            print(-(b-D**0.5)/(2*a))     
        else:
            print(-(b-D**0.5)/(2*a))     
            print(-(b+D**0.5)/(2*a))

    elif D == 0 and a != 0:  
        print(1)
        print(int(-b/(2*a)))        
    elif a == 0 and b != 0:
        print(1, -c/b , sep='\n')
    else:
        print(0)