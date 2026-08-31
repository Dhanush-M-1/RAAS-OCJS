a,b=map(int,input().split())
saat = 0
yananlar = 0
while a != 0 :
    saat += 1 
    a-=1
    yananlar += 1 
    if yananlar == b:
        yananlar = 0
        a+=1
print(saat)
