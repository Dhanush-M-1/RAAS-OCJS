l=[]
for _ in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    if a[0]+a[1]>a[-1]:
        l.append(-1)
    else:
        l.append(f"{1} {2} {len(a)}")
for i in l:
    print(i)