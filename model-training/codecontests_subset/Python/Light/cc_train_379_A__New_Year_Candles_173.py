inp=[int(i) for i in input().split()]
old=0
a=inp[0]
b=inp[1]
time=0

while a>0:
    a-=1
    old+=1
    time+=1
    if old>=b:
        a+=1
        old-=b

print(time)