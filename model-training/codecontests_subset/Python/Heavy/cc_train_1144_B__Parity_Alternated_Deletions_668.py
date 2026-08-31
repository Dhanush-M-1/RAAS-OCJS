N=int(input())
s=[int(x) for x in input().split()]
e=[]
o=[]
tot=0
tot1=0
tot2=0
for i in range(0,len(s)):
    if(s[i]%2==0):
        e.append(s[i])
        tot2=tot2+s[i]
    else:
        o.append(s[i])
        tot1=tot1+s[i]

    tot=tot+s[i]

o=sorted(o)
e=sorted(e)
o=o[::-1]
e=e[::-1]

#print(tot,tot1,tot2)
#print(o,e)

if(len(o)<len(e)):
    sumu=tot1
    h=e[:len(o)+1]
    for j in range(0,len(h)):
        sumu=sumu+h[j]
    print(tot-sumu)

elif(len(e)<len(o)):
    sumu=tot2
    h=o[:len(e)+1]
    for j in range(0,len(h)):
        sumu=sumu+h[j]
    print(tot-sumu)

else:
    print(0)

    
