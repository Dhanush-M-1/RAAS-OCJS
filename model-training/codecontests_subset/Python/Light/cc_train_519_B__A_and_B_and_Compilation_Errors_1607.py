n=int(input())
L=[int(i) for i in input().split()]
for i in range(0,2):
    L1=[int(i) for i in input().split()]
    print(sum(L)-sum(L1))
    L=L1
    L1=[]
