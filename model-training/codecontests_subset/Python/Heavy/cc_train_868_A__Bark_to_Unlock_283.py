p=input()
n=int(input())
l=[]
l1=[]
flag1=0
flag2=0
for i in range(n):
    l.append(input())
if p in l or p[::-1] in l:
    print ("YES")
else:
    for i in l:
        if (i[0]==p[0] or i[0]==p[1] or i[1]==p[0] or i[1]==p[1]):
            l1.append(i)
    #print (l1)      
    for i in l1:
        if i[1]==p[0]:
           flag1=1 
        if i[0]==p[1]   :
            flag2=1
   
    if flag1==1 and flag2==1:       
        print ("YES")
    else:
        print ("NO")
                

#print (l1)            