s=input().split()
print(" ".join(s))
n=int(input())
for i in range(n):
    a=input().split()
    if a[0]==s[0]:
        s[0]=a[1]
    else:
        s[1]=a[1]
    print(" ".join(s))
        
