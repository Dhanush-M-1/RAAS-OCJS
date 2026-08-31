a=list(map(int,input().split()))+[0,0]
while(a[0]>0)|(a[2]>a[1]):
 a[0],a[2],a[3]=0,a[2]+a[0],a[3]+a[0]
 a[0],a[2]=a[2]//a[1],a[2]%a[1]
print(a[3])
