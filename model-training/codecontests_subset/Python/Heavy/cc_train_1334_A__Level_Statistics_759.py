t=int(input())
for i in range(t):
    s="YES"
    l=[]
    n=int(input())
    for i in range(0,n):
        l1=[]
        a,b=input().split()
        a=int(a)
        b=int(b)
        l1.append(a)
        l1.append(b)
        l.append(l1)
    for i in range(0,len(l)):
        if(i==0):
            if(l[i][0]<l[i][1]):
                s="NO"
        elif(l[i][0]<l[i-1][0]):
            s="NO"
        elif(l[i][1]<l[i-1][1]):
            s="NO"
        elif(l[i][0]==l[i-1][0] and l[i][1]>l[i-1][0]):
            s="NO"
        elif(l[i][0]<l[i][1]):
            s="NO"
        elif(l[i][0]-l[i-1][0]<l[i][1]-l[i-1][1]):
            s="NO"
    print(s)
