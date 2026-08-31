n=int(input())
p=list(map(int, input().split()))
t=0
if max(p)<500001:
    print(max(p)-1)
else:
    p1=[]
    for i in p:
        if i>500000:
            p1.append(10**6-i)
        else:
            t=i-1
    print(max(max(p1),t))