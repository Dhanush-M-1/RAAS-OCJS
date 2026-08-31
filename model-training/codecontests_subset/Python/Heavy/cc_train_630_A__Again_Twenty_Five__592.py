'''
t= input()
lng= len(t)
li1=[]; li2=[]
for i in range(lng):
    if t[i]!='a':
        li1.append(t[i])
    elif t[i]=='a':
        li2.append(i)
        
aa= ''.join(li1)
if len(aa)==0:
    print(t); exit(0)
if len(aa)%2==1:
    print(':('); exit(0)
if len(aa)%2==0:
    #print(123)
    l= int(len(aa)/2); lp= l#; print(l)
    ll= aa[l:]; lll=aa[0:l] #; print(ll)
    if ll!=lll:
        print(':('); exit(0)
    if ll not in t:
        print(':('); exit(0)
    tp= t[::-1]; tc= ll[::-1]#; print(tp,tc)
    if tp.find(tc)!=0:
        print(':('); exit(0)
    if tp.find(tc)==0:
        ul= len(tc)
        lu= tp[ul:][::-1]
        print(lu); exit(0)
        
   '''
#print(ord("T")-ord('A')+1)
'''
def fk (a):
    if a=='ACTG':
        return 0
   # print(a)
    cv=0
   # cv+= min(abs(ord(a[0])-ord('A')), (ord('A')-ord('A')+1+ 26- ord(a[0])))
    cv+= (min(abs(ord(a[0])-ord('A')), (ord('A')-ord('A')+1+ 26- (ord(a[0])-ord('A')+1) ), (ord(a[0])-ord('A')+ abs(27- (ord("A")-ord('A')+1)) ) ))
    
   # cv+= min(abs(ord(a[1])-ord('C')), (ord('C')-ord('A')+1+ 26- ord(a[1])))
    cv+= (min(abs(ord(a[1])-ord('C')), (ord('C')-ord('A')+1+ 26- (ord(a[1])-ord('A')+1) ), (ord(a[1])-ord('A')+ abs(27- (ord("C")-ord('A')+1)) ) ))
    
    #cv+= min(abs(ord(a[2])-ord('T')), (ord('T')-ord('A')+1+ 26- ord(a[2])))#; print(abs(ord(a[2])-ord('T')), (ord('T')-ord('A')+1+ 26- ord(a[2])))
    cv+= (min(abs(ord(a[2])-ord('T')), (ord('T')-ord('A')+1+ 26- (ord(a[2])-ord('A')+1) ), (ord(a[2])-ord('A')+ abs(27- (ord("T")-ord('A')+1)) ) ))
    
    #cv+= min(abs(ord(a[3])-ord('G')), (ord('G')-ord('A')+1+ 26- ord(a[3])))
    cv+= (min(abs(ord(a[3])-ord('G')), (ord('G')-ord('A')+1+ 26- (ord(a[3])-ord('A')+1) ), (ord(a[3])-ord('A')+ abs(27- (ord("G")-ord('A')+1)) ) ))
    
    return cv

n= int(input()); s=input(); li=[]
for i in range(n-4+1):
    ab= s[i:i+4]
    li.append(fk(ab))
li.sort()
print(li[0])
'''
'''
n= int(input())
li= list(map(str, input().split())); li= li*2; li= ''.join(li); li= li.replace('0',' ')
li1= li.split()
try:
    print(len(max(li1)))
except:
    print(0)'''

'''
from math import *

def prmfct(n):
    li=[]
    while n%2==0:
        li.append(2)
        n= n/2
    for i in range(3,int(sqrt(n))+1,2):
        while n%i==0:
            li.append(int(i))
            n=int(n/i)
    if n>2:
        li.append(int(n))
        
        
    return li


n,m= input().split(); n,m= int(n), int(m)

if m%n!=0:
    print(-1)
else:
    lim= prmfct(int(m/n))
    li= list(set(lim))
    if len(li)==2 and li[0]==2 and li[1]==3:
        print(len(lim))
    elif len(li)==1 and (li[0]==2 or li[0]==3):
        print(len(lim))
    elif len(li)==0:
        print(0)
    else:
        print(-1)'''
'''
from math import *
a,b= input().split(); a,b= int(a), int(b)
print(factorial(min(a,b)))'''

n=int(input()); li=[6,8,4,2]
print(25)
        




    















'''
Abdul Hamid Shaodagor High School   Joni Kanti Pal  01306261062 Redwan Haque Ratul  01846509454
Hasne Hena Girls High School   Saiyeda Shahinur Parveen    01819858004 Habibur Rahman  01825374474
       ''' 














        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        