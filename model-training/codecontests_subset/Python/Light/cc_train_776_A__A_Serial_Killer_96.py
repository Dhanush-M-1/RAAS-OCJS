rip=input()
n=input()
n=int(n)
i=0
while i<n:
    rip=rip+'\n'+input()
    i=i+1
rip=rip.split('\n')
i=0
while i<len(rip):
 rip[i]=rip[i].split(' ')
 i=i+1
i=1
print(rip[0][0],rip[0][1])
while i<len(rip):
    if rip[i][0]==rip[i-1][0]:
        print(rip[i][1],rip[i-1][1])
        rip[i][0]=rip[i-1][1]
    else:
        print (rip[i][1],rip[i-1][0])
        rip[i][0]=rip[i-1][0]
    i=i+1
    
    

