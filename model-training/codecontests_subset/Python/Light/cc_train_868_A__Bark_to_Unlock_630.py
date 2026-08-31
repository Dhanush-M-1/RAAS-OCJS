s=input()
n=int(input())
S=[]
for i in range(n):
    S.append(input())
    
    
#print (S)
flag=0
for i in range(n):
    for j in range(n):
        if s in S[i]+S[j]:
            print ("YES")
            flag=1
            break
    if flag==1:
        break
           



if flag==0:
    print("NO")     
            