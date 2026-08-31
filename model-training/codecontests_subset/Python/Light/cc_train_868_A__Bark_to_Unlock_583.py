k=input()
n=int(input())
y,x=0,0
for i in range (n):
    s=input()
    if k==s : 
        x=y=1
    if k[0]==s[1]: x=1;
    if k[1]==s[0]: y=1
print ('YES' if x==1 and y==1 else 'NO') 