#339A
s=str(input())
a1=s.count('+1')
a2=s.count('+2')
a3=s.count('+3')
if s[0]=='1':
    a1=a1+1
elif s[0]=='2':
    a2=a2+1
elif s[0]=='3':
    a3=a3+1

if a1!=0:
    ss='1'
    for i in range(a1-1):
        ss=ss+'+1'
    for i in range(a2):
        ss=ss+'+2'
    for i in range(a3):
        ss=ss+'+3'
else:
    if a2!=0:
        ss='2'
        '''for i in range(a1-1):
            ss=ss+’+1’'''
        for i in range(a2-1):
            ss=ss+'+2'
        for i in range(a3):
            ss=ss+'+3'
    else:
        ss='3'
        for i in range(a3-1):
            ss=ss+'+3'
print(ss)
        
