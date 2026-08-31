# coding: utf-8
a, b = [int(i) for i in input().split()]
aa = 0
cnt = 0
while a:
    cnt += a
    temp = a+aa
    a = temp//b
    aa = temp%b
    
print(cnt)
