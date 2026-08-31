def twos(x):
    a=0
    while 1:
        if x==1:
            break
        if x%2==0:
            x=x//2
            a+=1
        else:
            break
    return a

def thres(y):
    b=0
    while 1:
        if y==1:
            break 
        if y%3==0:
            y=y//3
            b+=1
        else:
            break
    return b
    
for _ in range(int(input())):
    n=int(input())
    x=twos(n)
    y=thres(n)
    if n/(2**x*3**y)==1:
        if x>y:
            print(-1)
        else:
            print(y+y-x)
    else:
        print(-1)
