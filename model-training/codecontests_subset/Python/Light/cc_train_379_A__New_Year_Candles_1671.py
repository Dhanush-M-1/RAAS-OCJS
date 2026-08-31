from math import floor
a,b = map(int,input().split())
left = 0
hrs = 0
while a>0 or left>=b:
    #print("before",hrs,a,b,left)
    hrs += a
    if floor((left+a)/b)>floor(a/b):
        new = floor((left+a)/b)
        left = max((left+a)-(new*b),0)
    else:
        new = floor((a)/b)
        left += max(a-(new*b),0)
    a = new
    #print(hrs,a,b,left)
print(hrs)