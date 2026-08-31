op1,op2=[x for x in input().split(" ")]
print(op1,op2)
n=int(input())
while n:
    n-=1
    x,y=[x for x in input().split(" ")]
    if x==op1: op1=y
    elif x==op2: op2=y
    print(op1,op2)