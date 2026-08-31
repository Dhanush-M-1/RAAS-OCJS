l=list(input().split())
n=int(input())
print(l[0]+" "+l[1])
for i in range(n):
    a,b=input().split()
    if(l[0]==a):
        l[0]=b
    else:
        l[1]=b
    print(l[0]+" "+l[1])