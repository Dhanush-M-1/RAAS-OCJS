n=int(input())
s=list(input())
a0=s.count('0')
a1=s.count('1')
if a0==0:
    a0=-1
if a1==0:
    a1=-1
b0,b1=0,0
for i in range(n):
    if a0!=a1:
        print(1)
        print("".join(s))
        break
    if s[i]=='0':
        b0+=1
    else:
        b1+=1
    if b1!=b0 and (a0-b0)!=(a1-b1):
        L1="".join(s[:i+1])
        L2="".join(s[i+1:])
        if len(L2)==0:
            print(1)
            print(L1)
            break
        elif len(L1)==0:
            print(1)
            print(L2)
            break
        else:
            print(2)
            print(L1,end=" ")
            print(L2)
            break
        