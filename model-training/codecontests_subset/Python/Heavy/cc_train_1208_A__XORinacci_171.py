#-------------Program--------------
#----Kuzlyaev-Nikita-Codeforces----
#-------------Training-------------
#----------------------------------

t=int(input())
for i in range(t):
    a,b,n=map(int,input().split())
    if n%3==0:print(a)
    elif n%3==1:print(b)
    else:
        ab='';bb='';cb=''
        while a!=0:
            ab+=str(a%2)
            a=a//2
        while b!=0:
            bb+=str(b%2)
            b=b//2
        if len(ab)!=len(bb):
            if len(ab)<len(bb):
                ab+="0"*(len(bb)-len(ab))
            else:
                bb+="0"*(len(ab)-len(bb))
        ab=ab[::-1];bb=bb[::-1]
        for i in range(len(bb)):
            cb+=str((int(ab[i])+int(bb[i]))%2)
        E=0
        for i in range(len(cb)):
            E+=int(cb[i])*2**(len(cb)-1-i)
        print(E)