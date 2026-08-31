a, b = map(int, input().split())
i=0;s=0
while a > 0:
    i += a
    a,s = (a+s) // b,(a+s)%b
print(i)