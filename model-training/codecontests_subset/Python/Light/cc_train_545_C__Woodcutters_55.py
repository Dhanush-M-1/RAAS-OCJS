number=int(input())
x=[]
h=[]

if number<=2:
    print(number)
else:

    for i in range(number):
        a,b=map(int,input().split())
        x.append(a)
        h.append(b)
    ok=2
    for i in range(1,number-1):
        if x[i]-h[i]>x[i-1]:
            ok+=1
        else:
            if x[i]+h[i]<x[i+1]:
                ok+=1
                x[i]+=h[i]
    print(ok)