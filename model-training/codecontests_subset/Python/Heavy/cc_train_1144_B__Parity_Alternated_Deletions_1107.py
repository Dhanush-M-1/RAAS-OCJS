import math
a = int(input())
q = list(input().split())
s = 0
chet = []
nechet = []
for i in range(a):
    if int(q[i]) % 2 == 0:
        chet.append(int(q[i]))
    else:
        nechet.append(int(q[i]))
if max(len(chet), len(nechet)) - min(len(chet), len(nechet)) == 0 or max(len(chet), len(nechet)) - min(len(chet), len(nechet)) == 1:
    print(0)
else:
    nechet.sort()
    chet.sort()
    if len(chet) > len(nechet):
        n = chet
    elif len(chet) < len(nechet):
        n = nechet

    for i in range(max(len(chet), len(nechet)) - min(len(chet), len(nechet))-1):
        s += int(n[i])
    print(s)
