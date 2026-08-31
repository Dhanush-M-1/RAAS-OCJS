d = [int(x) for x in input().split(' ')]
h = 0
while(d[0]>0):
    h+=1
    d[0]-=1
    if(h%d[1]==0):
        d[0]+=1
print(h)