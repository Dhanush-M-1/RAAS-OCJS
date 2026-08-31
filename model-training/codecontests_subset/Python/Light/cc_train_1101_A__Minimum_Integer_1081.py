from math import *
q=int(input())
for i in range(q):
    l,r,d=map(int,input().split())
    num1=(ceil(l/d)-1)*d
    num2=((r//d)+1)*d
    if num1>0:
        print(d)
    else:
        print(num2)
