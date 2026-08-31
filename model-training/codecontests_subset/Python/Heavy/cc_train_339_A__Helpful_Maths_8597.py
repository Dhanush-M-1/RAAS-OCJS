n=input()
m=''
f=0
s=0
th=0
if len(n)==1:
    print(n)
else:
    for i in (n):
        if i=='3':
            th +=1
        if i=='2':
            s +=1
        if i=='1':
            f +=1

    for i in range (f):
        if m=='':
            m += '1'
        else:
            m += '+1'
    for i in range (s):
        if m=='':
            m += '2'
        else:
            m += '+2'
    for i in range (th):
        if m=='':
            m += '3'
        else:
            m += '+3'




print(m)



