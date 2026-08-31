# cook your dish here
n=list(map(int,input().rstrip().split()))
a=n[0]
b=n[1]
time=a
res=a
#a=int(a/b)

while (int(res/b))>0:
    time+=int(res/b)
    res=(res%b)+int(res/b)
    
print(time)