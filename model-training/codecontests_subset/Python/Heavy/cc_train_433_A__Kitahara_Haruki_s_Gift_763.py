import collections
n=int(input())
a=[int(i)for i in input().split()]
s=sum(a)
t=s//100
if t%2!=0:
    print("NO")
elif n==1:
    print("NO")
else:
    d=collections.Counter(a)
    if n%2==0:
        if d[100]%2==0 or d[200]%2==0:
            print("YES")
        else:
            print("NO")
    else:
        if d[100]%2!=0 and d[200]%2==0 and d[200]!=0:
            print("YES")
        elif d[100]%2==0 and d[200]%2!=0 and d[100]!=0:
            print("YES")
        else:
            print("NO")