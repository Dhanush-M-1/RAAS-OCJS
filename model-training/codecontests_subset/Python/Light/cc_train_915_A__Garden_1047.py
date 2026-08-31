n,k=map(int,input().split());
a=list(map(int,input().split()));
L=[];
for i in range(n):
    if(k % a[i] == 0):
        L.append(k//a[i]);
min=L[0];
for j in range(1,len(L)):
    if (L[j]<min):
        min=L[j];
print(min);


        
    
