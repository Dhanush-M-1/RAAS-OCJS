'''
Created on Apr 18, 2016
Gmail : r.haque249.rh@gmail.com
@author: Md. Rezwanul Haque
'''
raw = input()
s = raw.replace('?', '')
n =int(s.split( )[-1])
m = s.count('-')
p = s.count('+')
c = p - m
'''print("S = ",s)
print("n = ",n)
print("m = ",m)
print("p = ",p)
print("c = ",c)'''
if (p+1)*n - m < n or p+1 - m*n >n:
    print('Impossible')
else:
    print('Possible')
    rez = n-c 
    s = raw[1:]
    #print("Ss = ",s)
    #? + ? - ? + ? + ? = 42
    while rez > n or rez <1:
        if rez>n:
            s = s.replace("+ ?","+ "+str(n),1)
            rez -= n-1
        else:
            s = s.replace("- ?","- "+str(n),1)
            rez += n-1
    print(str(rez)+s.replace('?','1'))
