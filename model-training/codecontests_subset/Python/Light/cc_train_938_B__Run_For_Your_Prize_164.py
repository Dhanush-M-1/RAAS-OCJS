pr = int(input())
text = input().split()
x = 0
xx = 0
a = []
b = []
for i in text:
    i = int(i)
    if i <= 500000:
        a.append(i)
    else:
        b.append(i)
if len(b) >= 1 and len(a) >= 1:
    print(max(a[-1]-1,10**6-b[0]))
elif len(a) == 0:
    print(10**6-b[0])
else:
    print(a[-1]-1)