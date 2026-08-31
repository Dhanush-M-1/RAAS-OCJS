def dl(n,a):
    for i in range(n):
        if (n/a**i)==(n//a**i):
            continue
        else:
            return(int(i-1))
t=int(input())
l=[]
for i in range(t):
    n=int(input())
    if n==1:
        l.append(0)
    else:
        two=dl(n,2)
        six=dl(n,3)
        if six==0:
            l.append(-1)
        else:
            if (2**two)*(3**six)==n:
                if two>six:
                    l.append(-1)
                else:
                    l.append(2*six-two)
            else:
                l.append(-1)
for i in l:
    print(i)