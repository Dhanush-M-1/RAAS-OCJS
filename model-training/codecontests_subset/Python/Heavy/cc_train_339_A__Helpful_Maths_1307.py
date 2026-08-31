s = input()
d = {}
s1 = sorted(s)
count = 0
for i in s1:
    if i == '+':
        count+=1
    else:
        print(i,end="")
        if(count > 0):
            print('+',end="")
            count-=1
"""
d['+'] = 0
for i in s:
    d.setdefault(i, 0)
    d[i]+=1
for i in sorted(d.keys()):
    if i == '+':
        continue
    else:
        while True:
            if d[i] == 0:
                break
            s1+=i
            if d['+'] > 0:
                s1+='+'
                d['+']-=1
            d[i]-=1
print(s1)
"""