def min(a, b):
    if(a < b):
        return a
    else:
        return b

n=int(input())
for i in range(n):
    a,b,c = map(int, input().split())
    
    x = min(b, c//2)
    b = b - x
    c = c - 2*x
    y = min(a, b//2)
    
    print(3*(x+y))
    '''
    if (c>=(2*b)):
        stones=3*b
    elif (c<(2*b)):
        if (((2*b)-c)<2):
            stones=3*(c//2)
        else:
            if ((b-(c//2)>=(2*a))):
                stones=(3*(c//2))+(3*a)
            else:   
                stones=(3*(c//2))+(3*((b-(c//2))//2))
for i in (1,n+1):
    print(stones)
    '''
