a,b = map(int,input().split())
res = a
rem = 0
while a > 0:
        a += rem
        s = a // b
        res += s
        rem = a % b
        a = s
print(res)