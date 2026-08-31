a,b = map(int,input().split())
flag = True
count = a
while flag != False:
    if(a >= b):
        count = count + a//b
        a = a // b + a % b
    else:
        flag = False
print(count)