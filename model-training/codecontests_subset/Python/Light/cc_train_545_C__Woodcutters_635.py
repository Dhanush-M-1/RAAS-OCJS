# 545C
n = int(input())
res = 0
left = -10**10
a = input().split()
a = list(map(int,a))
x_cur = a[0]
h_cur = a[1]
for i in range(n-1):
    a = input().split()
    a = list(map(int,a))
    x_next = a[0]
    h_next = a[1]
    if x_cur-h_cur > left:
        res += 1
        left = x_cur
    else:
        if x_cur+h_cur < x_next:
            res += 1
            left = x_cur+h_cur
        else:
            left = x_cur
    x_cur = x_next
    h_cur = h_next 
print(res+1)