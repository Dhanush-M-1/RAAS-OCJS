[a,b] = list(map(int,input().split()))
h = 0
c = a
des = 0
flag = True
while flag:
    if des == b:
        c += 1
        des -=  b 
    if c == 0:
        flag = False
    else:
        c -= 1
        h += 1
    des += 1
    
print(h)