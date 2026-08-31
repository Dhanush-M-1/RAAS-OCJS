n = int(input())
s = input().split()
ser = (1+10**6)/2
mn = ser
res = 0
for i in s:
    if abs(ser-int(i))<mn:
        mn = abs(ser-int(i))
        res = int(i)

if res - ser<0:
    print(res-1)
else:
    print(10**6-res)