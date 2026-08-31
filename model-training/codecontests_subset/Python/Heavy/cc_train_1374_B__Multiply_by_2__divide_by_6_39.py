import string
import math
n=int(input())
while(n>0):
    arr = list(map(int, input().strip().split()))
    x=arr[0]
    y=x
    two=0
    three=0
    fl=0

    while(x>1):
        if(x%2==0):
            x=x/2
            two=two+1
        elif(x%3==0):
            x=x/3
            three=three+1
        elif(x!=1):
            fl=-1
            break;
    if(y==1):
        print(0)
    elif(fl==-1):
        print(-1)
    else:
        if(three>=two):
            print(three+three-two)
        else:
            print(-1)



    n=n-1