a,b = map(int,input().split())
ogarki=0
svechi=a
count=0
while svechi>0:
    svechi-=1
    ogarki+=1
    if ogarki==b:
        svechi+=1
        ogarki-=b
    count+=1
print(count)