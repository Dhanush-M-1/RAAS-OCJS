a,b=map(str,input().split())
print(a,b)
n=int(input())
for i in range(n):
    h,k=map(str,input().split())
    if(h==a):
        a=k
    else:
        b=k
    print(a,b)