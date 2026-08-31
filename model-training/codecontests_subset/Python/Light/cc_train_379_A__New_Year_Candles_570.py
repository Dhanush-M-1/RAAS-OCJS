a, b = input().split()
tunde = 0
jaak = 0
terveid = int(a)
while True:
    tunde += terveid
    poolikuid = terveid + jaak
    terveid = poolikuid // int(b)
    jaak = poolikuid % int(b)
    if terveid == 0:
        break
print(tunde)