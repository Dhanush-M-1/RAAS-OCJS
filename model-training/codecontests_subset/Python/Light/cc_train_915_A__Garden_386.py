A=input()
A=A.split(" ")
B=input()
B=B.split(" ")
C=[]
i=0;
while (i<len(B)):
    
    if (int(A[1])%int(B[i])==0):
        C.append(int(A[1])//int(B[i]))
    i+=1
print(min(C))
    
