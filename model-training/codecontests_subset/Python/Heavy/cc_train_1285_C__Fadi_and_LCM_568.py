def function(a,b):
    if (b%a==0):
        return False
    else:
        for i in range(2,a//2+1):
            if ((a%i==0) and (b%i==0)):
                return False
        return True
import math
X=int(input())
if (X==1):
    print("1","1")
else:
    x=int(math.sqrt(X))
    i=x
    k="y"
    while((k=="y") and (i>=2)):
        if (X%i==0):
            y=X//i
            if (i!=y):
                if(function(i,y)):
                    print(i,y)
                    k="n"
        i=i-1
    if (k=="y"):
        print("1",X)