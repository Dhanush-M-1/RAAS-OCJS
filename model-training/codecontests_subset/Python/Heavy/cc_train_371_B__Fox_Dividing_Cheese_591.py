from math import sqrt, floor
n,m=input().split()
n=int(n)
m=int(m)
def fact(n):
    primes=[]
    powers=[]
    for i in range(2,floor(sqrt(n)+1)):
        if n%i==0:
            power=0
            while n%i==0:
                power=power+1
                n=n//i
            primes.append(i)
            powers.append(power)
    if n!=1:
        primes.append(n)
        powers.append(1)
    return [primes, powers]
nn=fact(n)
mm=fact(m)
npr=nn[0]
npw=nn[1]
mpr=mm[0]
mpw=mm[1]
cn2=0
cn3=0
cn5=0
cm2=0
cm3=0
cm5=0
if 2 in npr:
    cn2=npw[0]
if 3 in npr:
    cn3=npw[npr.index(3)]
if 5 in npr:
    cn5=npw[npr.index(5)]
if 2 in mpr:
    cm2=mpw[0]
if 3 in mpr:
    cm3=mpw[mpr.index(3)]
if 5 in mpr:
    cm5=mpw[mpr.index(5)]
ii=-1
jj=-1
for i in range(len(npr)):
    if 30%npr[i]!=0:
        ii=i
        break
for i in range(len(mpr)):
    if 30%mpr[i]!=0:
        jj=i
        break
if ii==-1 and jj==-1:
    print(abs(cn2-cm2)+abs(cn3-cm3)+abs(cn5-cm5))
elif ii==-1 or  jj==-1:
    print(-1)
else:
    if npr[ii:]!=mpr[jj:]:
        print(-1)
    elif npw[ii:]!=mpw[jj:]:
        print(-1)
    else:
        print(abs(cn2-cm2)+abs(cn3-cm3)+abs(cn5-cm5))
	 	 		 	 	   			  	 	 			 	 	 	