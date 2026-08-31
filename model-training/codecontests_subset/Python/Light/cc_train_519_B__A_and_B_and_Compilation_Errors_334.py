n=int(input());l=lambda:map(int,input().split());a=list(l());b=list(l());c=list(l())
a.sort();b.sort();c.sort();b.append(0);c.append(0);c.append(0)
for i in range(n):
    if(a[i]!=b[i]):
        print(a[i]);break
for i in range(n):
    if (b[i] != c[i]):
        print(b[i]);break;