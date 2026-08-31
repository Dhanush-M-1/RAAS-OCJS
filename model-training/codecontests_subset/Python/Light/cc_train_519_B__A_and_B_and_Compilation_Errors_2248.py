a,b,c,d=input(),sorted(map(int,input().split())),sorted(map(int,input().split())),sorted(map(int,input().split()))
true=False
for i in range(len(c)):
    if b[i]!=c[i]:
        print(b[i])
        true=True
        break
if not true:
    print(b[-1])
true=False
for i in range(len(d)):
    if d[i]!=c[i]:
        print(c[i])
        true=True
        break
if not true:
    print(c[-1])