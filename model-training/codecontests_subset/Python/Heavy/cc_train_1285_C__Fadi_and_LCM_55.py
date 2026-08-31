import math
x = int(input())
lst = []
sq = int(math.sqrt(x))
for i in range(1, sq+1):
    if i*i == x:
        lst.append((i, i))
    else:
        if(x % i == 0):
            j = int(x/i)
            if(j % i != 0 or i == 1):
                lst.append((i, j))
mini = x + 1
n = len(lst)
for i in range(n):
    if(int(lst[i][0]*lst[i][1]/math.gcd(lst[i][0], lst[i][1])) == x):
        if lst[i][1] < mini:
            mini = lst[i][1]
            ele = lst[i][0]
            ele1 = lst[i][1]
print(ele, ele1)
