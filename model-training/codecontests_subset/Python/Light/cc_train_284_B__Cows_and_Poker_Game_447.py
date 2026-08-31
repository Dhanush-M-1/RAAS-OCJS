n=int(input())
s=input()
A=0
I=0
for i in range(n):
    if(s[i]=='A'):
        A+=1
    elif(s[i]=='I'):
        I+=1
if(I==1):
    print(I)
elif(I>1):
    print("0")
else:
    print(A)