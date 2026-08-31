n=input()
a=n.count('1')
b=n.count('2')
c=n.count('3')
if '+'in n:
    if c!=0:
        s=''
        for i in range(a):
            s+='1+'
        for i in range(b):
            s+='2+'
        for i in range(c-1):
            s+='3+'
        s+='3'
        print(s)
    elif c==0:
        s=''
        if b==0:
            for i in range(a-1):
                s += '1+'
            s+='1'
            print(s)
        else:
            for i in range(a):
                s += '1+'
            for i in range(b-1):
                s += '2+'
            s+='2'
            print(s)
else:
    print(n)
