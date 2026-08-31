import re
arr = re.split(' ', input())
A = int(arr[0])
B = int(arr[1])
C = int(arr[2])
dis = B*B-4*A*C

if (A == 0 and B == 0 and C == 0):
    print(-1)
elif (A == 0 and B == 0):
    print(0)
elif (A == 0):
    print(1)
    print(-C/B)
elif (dis<0):
    print(0)
elif (dis==0):
    print(1)
    print(-B/(2*A))
else:
    print(2)
    if (A>0):
        print((-B-dis**0.5)/(2*A))
        print((-B+dis**0.5)/(2*A))
    else:
        print((-B+dis**0.5)/(2*A))
        print((-B-dis**0.5)/(2*A))
    


    
