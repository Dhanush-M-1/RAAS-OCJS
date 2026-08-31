for _ in range(int(input())):
    l,r,d=[int(x) for x in input().split()]
    if l%d==0:
        num1=l//d
        num1-=1
    else:
        num1=l//d
    num2=r//d
    num2+=1
    if num1>=1:
        print(d)
        continue
    else:
        print(num2*d)
        continue
    