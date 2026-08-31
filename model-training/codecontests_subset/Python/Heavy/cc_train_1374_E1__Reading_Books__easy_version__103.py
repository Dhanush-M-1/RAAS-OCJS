import sys
input=sys.stdin.readline
n,k=map(int,input().split())
both=[]
ali=[]
bli=[]
for i in range(n):
    t,a,b=map(int,input().split())
    if(a==1 and b==1):
        both.append(t)
    if(a==1 and b==0):
        ali.append(t)
    if(a==0 and b==1):
        bli.append(t)
lboth=len(both)
lali=len(ali)
lbli=len(bli)
if(lboth+lali<k or lboth+lbli<k):
    print(-1)
else:
    both.sort(reverse=True)
    ali.sort(reverse=True)
    bli.sort(reverse=True)
    ans=0
    for i in range(k):
        if(lboth!=0 and lali!=0 and lbli!=0):
            if(both[-1]<=ali[-1]+bli[-1]):
                ans+=both[-1]
                both.pop()
                lboth-=1
            else:
                ans+=(ali[-1]+bli[-1])
                lali-=1
                lbli-=1
                ali.pop()
                bli.pop()
        elif(lboth==0):
            ans+=(ali[-1]+bli[-1])
            lali-=1
            lbli-=1
            ali.pop()
            bli.pop()
        elif(lali==0 or lbli==0):
            ans+=both[-1]
            both.pop()
            lboth-=1
    print(ans)
            
                