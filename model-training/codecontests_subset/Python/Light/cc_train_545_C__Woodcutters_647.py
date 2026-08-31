n = int(input())
x, h = map(int, input().split(" "))
ans = 1
p = -h-x-1
for i in range(1, n):
    xx, hh = x, h
    x, h = map(int, input().split(" "))
    if xx - p > hh:
        p = xx
        ans+=1
    elif xx + hh < x :
        p = xx + hh
        ans+=1
    else :
        p = xx
        
print(ans)