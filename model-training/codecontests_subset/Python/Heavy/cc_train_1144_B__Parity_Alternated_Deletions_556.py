import sys

n = int(sys.stdin.readline())
arr = [int(i) for i in sys.stdin.readline().split()]
c = []
d = []
for i in arr:
    if i % 2 == 0:
        c.append(i)
    else:
        d.append(i)
c.sort()
d.sort()
if abs(len(d)-len(c))<2:
    print(0)
else:
    if len(d) == 0 or len(c) == 0:
        if len(d) == 0:
            print(sum(c[:-1]))
        else:
            print(sum(d[:-1]))
    else:
        if len(d) > len(c):
            print(sum(d[:-len(c)-1]))
        else:
            print(sum(c[:-len(d)-1]))