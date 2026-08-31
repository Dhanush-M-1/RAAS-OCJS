l=list(map(int,input().split()))
n,y=l[0],l[1]
fir=[]
sec=[]
bot=[]
for _ in range(n):
    k=list(map(int,input().split()))
    if(k[1]==1 and k[2]==1):
        bot.append(k[0])
    elif(k[1]==1 and k[2]==0):
        fir.append(k[0])
    elif(k[1]==0 and k[2]==1):
        sec.append(k[0])
f=len(fir)
s=len(sec)
b=len(bot)
if(f+b<y or s+b<y):
    print(-1)
else:

    fir.sort()
    sec.sort()
    bot.sort()

    if(f<y):
        fir+=((y-f)*[10001])
    else:
        fir=fir[0:y]
    if(s<y):
        sec+=((y-s)*[10001])
    else:
        sec=sec[0:y]
    val=sum(fir)+sum(sec)   
    fir.reverse()
    sec.reverse()
    for i in range(y):
        try:
            if(fir[i]+sec[i]>bot[i]):
                val=val-fir[i]-sec[i]+bot[i]
        except:
            break
    print(val)