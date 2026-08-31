import sys
r=input()
r,n=r.split('=')
z=''
for i in r: z=z+i*(i in ['+','-'])
r=z
n=int(n)
p,v=r.count('+')+1,r.count('-')
if not(p-n*v<=n<=p*n-v):
    print('Impossible')
    sys.exit()
print('Possible')
s=0
ans=''
for i in range(len(r)):
    zn=1
    if i>0 and r[i-1]=='-': zn=-1
    if zn==1: p-=1
    else: v-=1 
    for x in range(1,n+1):
        if s+x*zn+p-n*v<=n<=s+x*zn+p*n-v:
            s+=x*zn
            zn='+' if zn==1 else '-'
            ans=ans+str(x)+' '+str(r[i])+' '
            break
ans=ans+str(abs(n-s))+' '
print(ans+'= '+str(n))