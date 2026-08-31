import math
for t in range(int(input())):
    l,r,d = [int(x) for x in input().split(" ")]
    if(d<l or d>r):
        print(d)
    else:
        if(r%d==0):
            print(int(((r/d+1)*d)))
        else:
            print(int(math.ceil(r/d)*d))