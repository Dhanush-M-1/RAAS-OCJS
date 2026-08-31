def findhcf(x, y):
    while(y):
        x, y = y, x%y
    return x
def haha(a):
    if len(a) == 1:
        return a[0]
    if len(a) == 2:
        return findhcf(a[0], a[1])
    b = [findhcf(a[-2], a[-1])]
    i = 0
    while i < len(a) - 1:
        b.append(findhcf(a[i], a[i+1]))
        i += 2
    set(b)
    return haha(b)
        
k = input()
ha = input()
num0 = ha.split(' ')
num = []
diff = []
hcf = 1
for i in num0:
    num.append(int(i))
max0 = max(num)
num1 = num
set(num1)
for i in num1:
    t = max0 - i
    if t > 0:
        diff.append(t)
hcf = haha(diff)
tsum = 0
for i in num:
    tsum += int((max0 - i)/hcf)
print(str(tsum) + ' ' + str(hcf))