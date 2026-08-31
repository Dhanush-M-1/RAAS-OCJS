
import math
n,x,y = map(int, input().split())
extraPeopleNeeded = math.ceil(y*n/100)
if(extraPeopleNeeded > x):
    print (extraPeopleNeeded - x)
else:
        print(0)