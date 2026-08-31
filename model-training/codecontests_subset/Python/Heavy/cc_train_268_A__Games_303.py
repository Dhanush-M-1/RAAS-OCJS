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
n=int(input())
l=[]
for i in range(n):
    l.append(seperateints(input()))
nn=0    
for i in range(n):
      for k in range(n):
          if k<=i : continue
          if l[i][1]==l[k][0]:
              nn+=1
          if l[i][0]==l[k][1]:
              nn+=1
print(nn)              
        