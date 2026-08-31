n=int(input())
s=input()
k=''
if s.count('0')!=s.count('1'):
    print(1)
    print(s)
else:
    if len(s)>=3:
        i=2
        k+=s[0]
        k+=s[1]
        while i<len(s):
            a0=k.count('0')
            a1=k.count('1')
            if a0!=a1:
                break
            else:
                k+=s[i]
            i=i+1
        k1=''
        l=len(k)
        i=l
        while i<len(s):
            k1+=s[i]
            i=i+1
        print(2)
        print(k,k1)
    else:
        print(2)
        print(s[0],s[1])
        