n,k=map(int,input().split())
bot,ali,bob=[],[],[]
alicetime,bobtime,count=0,0,0
for i in range(n):
    t,a,b=map(int,input().split())
    if a==1 and b==1:
        bot.append(t)
    elif a==1 and b==0:
        ali.append(t)
    elif a==0 and b==1:
        bob.append(t)
bot.sort(reverse=True)
ali.sort(reverse=True)
bob.sort(reverse=True)
while len(bot)>0 and len(ali)>0 and len(bob)>0 and alicetime<k and bobtime<k:
    if bot[-1]<=(ali[-1]+bob[-1]):
        x=bot.pop()
        count+=x
        alicetime+=1
        bobtime+=1
    else:
        y=ali.pop()
        z=bob.pop()
        count+=(y+z)
        alicetime+=1
        bobtime+=1
if len(bot)==0 and len(ali)>0 and len(bob)>0 and alicetime<k and bobtime<k:
    while len(ali)>0 and len(bob)>0 and alicetime<k and bobtime<k:
        y=ali.pop()
        z=bob.pop()
        count+=(y+z)
        alicetime+=1
        bobtime+=1
elif len(bot)>0 and (len(ali)==0 or len(bob)==0) and alicetime<k and bobtime<k:
    while len(bot)>0 and alicetime<k and bobtime<k:
        x=bot.pop()
        count+=x
        alicetime+=1
        bobtime+=1
if alicetime!=k or bobtime!=k:
    print(-1)
else:
    print(count)                     