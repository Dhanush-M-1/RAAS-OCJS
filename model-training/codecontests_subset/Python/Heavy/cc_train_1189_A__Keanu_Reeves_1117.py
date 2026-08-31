n=int(input())
s=input()
c=c0=c1=c2=c3=c4=0
for k in s:
    if k=='0':
        c+=1
    else:
        c0+=1
if c!=c0:
    print("1")
    print(s)
else:
    for i in range(n):
        s1=s[:i+1]
        s2=s[i+1:]
        for j in s1:
            if j=='0':
                c1+=1
            else:
                c2+=1
        for j in s2:
            if j=='0':
                c3+=1
            else:
                c4+=1
        if c1!=c2 and c3!=c4:
            print(2)
            print(s1,s2)
            break
