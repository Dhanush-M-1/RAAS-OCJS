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

n= int(input()); li=list(map(int,input().split())); li1=[]; li2=[]; li.sort()#; li=li[::-1]
for i in li:
    if i%2==0:
        li1.append(i)
    else:
        li2.append(i)
l1= len(li1); l2= len(li2)

if l1==l2 or abs(l1-l2)==1:
    print(0)
elif l1>l2:
    m= l1-l2-1
    print(sum(li1[0:m]))
elif l2>l1:
    m= l2-l1-1
    print(sum(li2[0:m]))
    















'''
Abdul Hamid Shaodagor High School   Joni Kanti Pal  01306261062 Redwan Haque Ratul  01846509454
Hasne Hena Girls High School   Saiyeda Shahinur Parveen    01819858004 Habibur Rahman  01825374474
       ''' 














        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        