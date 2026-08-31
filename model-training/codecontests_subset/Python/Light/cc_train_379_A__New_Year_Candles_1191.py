def read_array():
    x = []
    x1 = []
    x = input()
    x = x.split(' ')
    for r in range(len(x)):
        x1.append(int(x[r]))
    return x1

x=read_array()
socks=x[0]
count=socks
sobra=0
m=x[1]
days=0
while socks>0:
    days+=1
    socks-=1
    if days%m==0:
        socks+=1
print(days)


