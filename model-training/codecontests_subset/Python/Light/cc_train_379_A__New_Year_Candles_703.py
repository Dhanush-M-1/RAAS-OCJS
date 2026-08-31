list = [int (x) for x in input().split()]
a = list[0]
b = list[1]
hours =0
burn =0
if a<b: print(a)
else:
    while a :
        hours+=1
        a-=1
        burn+=1
        if burn==b:
            burn=0
            a+=1
    print(hours)