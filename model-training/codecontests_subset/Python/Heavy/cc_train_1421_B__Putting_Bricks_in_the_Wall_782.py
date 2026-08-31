import math
def solve():
    s=[]
    n=int(input())
    for i in range(n):
        s.append(input())
    p,q,r,s=s[0][1],s[1][0],s[n-2][n-1],s[n-1][n-2]
    x=''.join(sorted(p+q))
    y=''.join(sorted(r+s))
    if((x=='00' and y=='11') or (x=='11' and y=='00')):
        print(0)
    elif((x=='00' and y=='00') or (x=='11' and y=='11')):
        print(2)
        print(n-1,n)
        print(n,n-1)
    elif(x=='01' and y=='01'):
        print(2)
        if(p=='0'):
            print("1 2")
        else:
            print("2 1")
        if(r=='1'):
            print(n-1,n)
        else:
            print(n,n-1)
    elif(x=="00" and y=='01'):
        print(1)
        if(r=='0'):
            print(n-1,n)
        else:
            print(n,n-1)
    elif(x=='01' and y=='00'):
        print(1)
        if(p=='0'):
            print("1 2")
        else:
            print("2 1")
    elif(x=='01' and y=='11'):
        print(1)
        if(p=='1'):
            print("1 2")
        else:
            print("2 1")
    elif(x=='11' and y=='01'):
        print(1)
        if(r=='1'):
            print(n-1,n)
        else:
            print(n,n-1)
    else:
        print(0)
    
for z in range(int(input())):
    solve()
