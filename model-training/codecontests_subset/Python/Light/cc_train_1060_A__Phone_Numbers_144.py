n=int(input())
ph=str(input())
ct=0
for i in range(0,n):
    if(ph[i]=='8'):
        ct+=1
if(n<11):
    print("0")
    exit()
elif(ct==0):
    print("0")
    exit()
else:
    tt=0
    tt=n//11
    print(min(tt,ct))
