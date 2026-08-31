def divide(n, x):
    res = 0
    while(n > x):
        n = n//2
        res += 1
    return res,n

def comp(x, a, idx):
    add = 0
    inc = 0
    check = x
    res = 1000000000
    flag = 0
    for j in range(idx+1,n):
        if inc >= k-1:
            flag = 1
            res = min(res,add)
            break
        count,x = divide(a[j],check)
        if x == check:
            add += count
            inc += 1
    if inc >= k-1:
        flag = 1
        res = min(res,add)
    if flag == 0:
        return -1
    else:
        return res
    
n,k = map(int, input().split(" "))
a = list(map(int, input().split(" ")))
a = sorted(a)
res = 1000000000
for i in range(n):
    counter = 0
    temp = 0
    lol = a[i]
    while(lol > 0):
        temp = comp(lol,a,i)
        if temp >= 0:
            res = min(res,temp+counter)
        lol = lol//2
        counter += 1
print(res)
        
