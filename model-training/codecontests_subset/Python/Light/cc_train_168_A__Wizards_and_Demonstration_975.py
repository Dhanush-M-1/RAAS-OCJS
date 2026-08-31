import math
arr=list(map(int,input().split()))
total=arr[0]
wiz=arr[1]
per=arr[2]
required=math.ceil((total*per)/100)
# print("Required: ",required)
if required<=wiz:
    print("0")
else:
    print(required-wiz)