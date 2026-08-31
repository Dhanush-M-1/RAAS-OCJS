def seperateints(x):  
    k=''
    l=[]
    for i in x :
        if i==' ' :
            l.append(int(k))
            k=''
            continue 
        k=k+i
    l.append(int(k))   
    return(l)
def luckynum(x):
    for i in x : 
        if i!='4' and i!='7' :
            return False
    return True 
l=seperateints(input())
n=l[0]
if l[0]>=l[1] :
    while True :
        if l[0]%l[1]==0 :
            l[0]=l[0]//l[1]
            n=n+l[0]
        else :
            x=l[0]//l[1]
            l[0]=x+l[0]%l[1]
            n=n+x
        if l[0]<l[1]: break    
print(n)    