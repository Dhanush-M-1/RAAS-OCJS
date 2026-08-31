n=int(input())
s=input()
c=s.count('8')
if c==0 or n<11:
    print(0)
    exit()
num=n-c
ans=0
#print(num,c)
while(True):
    if c<1:
        break
    if num>=10 and c>=1:
        ans+=1
        num-=10
        c-=1
    elif num<10:
        if num+c>=11:
            ans+=1
            c-=(11-num)
            num=0
        else:
            break
    elif num+c<11:
        break
print(ans)