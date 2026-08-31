import math
ar=list(map(float,input().split()))
mn=-float('inf')
mns=""
def xyz(x,y,z,op):
    if(op==1):
        return (x**y**z,"x^y^z")
    elif(op==2):
        return (x**z**y,"x^z^y")
    elif(op==5):
        return (y**x**z,"y^x^z")
    elif(op==6):
        return (y**z**x,"y^z^x")
    elif(op==9):
        return (z**x**y,"z^x^y")
    elif(op==10):
        return (z**y**x,"z^y^x")
    elif(op==3):
        return ((x**y)**z,"(x^y)^z")
    elif(op==4):
        return ((x**z)**y,"(x^z)^y")
    elif(op==7):
        return ((y**x)**z,"(y^x)^z")
    elif(op==8):
        return ((y**z)**x,"(y^z)^x")
    elif(op==11):
        return ((z**x)**y,"(z^x)^y")
    elif(op==12):
        return ((z**y)**x,"(z^y)^x")
def xyz2(x,y,z,op):
    if(op==1):
        try:
            vl=math.log2(math.log2(x))+math.log2(y)*z
        except:
            vl=-float('inf')
        return (vl,"x^y^z")
    elif(op==2):
        try:
            vl=math.log2(math.log2(x))+math.log2(z)*y
        except:
            vl=-float('inf')
        return (vl,"x^z^y")
    elif(op==5):
        try:
            vl=math.log2(math.log2(y))+math.log2(x)*z
        except:
            vl=-float('inf')
        return (vl,"y^x^z")
    elif(op==6):
        try:
            vl=math.log2(math.log2(y))+math.log2(z)*x
        except:
            vl=-float('inf')
        return (vl,"y^z^x")
    elif(op==9):
        try:
            vl=math.log2(math.log2(z))+math.log2(x)*y
        except:
            vl=-float('inf')
        return (vl,"z^x^y")
    elif(op==10):
        try:
            vl=math.log2(math.log2(z))+math.log2(y)*x
        except:
            vl=-float('inf')
        return (vl,"z^y^x")
    elif(op==3):
        try:
            vl=math.log2(math.log2(x))+math.log2(y)+math.log2(z)
        except:
            vl=-float('inf')
        return (vl,"(x^y)^z")
    elif(op==4):
        try:
            vl=math.log2(math.log2(x))+math.log2(z)+math.log2(y)
        except:
            vl=-float('inf')
        return (vl,"(x^z)^y")
    elif(op==7):
        try:
            vl=math.log2(math.log2(y))+math.log2(x)+math.log2(z)
        except:
            vl=-float('inf')
        return (vl,"(y^x)^z")
    elif(op==8):
        try:
            vl=math.log2(math.log2(y))+math.log2(x)+math.log2(z)
        except:
            vl=-float('inf')
        return (vl,"(y^z)^x")
    elif(op==11):
        try:
            vl=math.log2(math.log2(z))+math.log2(x)+math.log2(y)
        except:
            vl=-float('inf')
        return (vl,"(z^x)^y")
    elif(op==12):
        try:
            vl=math.log2(math.log2(z))+math.log2(x)+math.log2(y)
        except:
            vl=-float('inf')
        return (vl,"(z^y)^x")
E=[[0,1,2],[0,2,1],[1,0,2],[1,2,0],[2,0,1],[2,1,0]]
if(max(ar)<4.1):
    for i in range(1,13):
        a=xyz(ar[0],ar[1],ar[2],i)
        #print(a)
        if(a[0]-1e-7>mn):
            mn=a[0]
            mns=a[1]
else:
    for i in range(1,13):
        a=xyz2(ar[0],ar[1],ar[2],i)
        #print(a)
        if(a[0]-1e-7>mn):
            mn=a[0]
            mns=a[1]
print(mns)
    
