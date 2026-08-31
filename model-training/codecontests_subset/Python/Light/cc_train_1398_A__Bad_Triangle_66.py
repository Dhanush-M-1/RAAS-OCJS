import sys

I = lambda: int(input())
RL = readline = lambda: sys.stdin.readline().strip('\n')
RM = readmap  = lambda x = int: map(x,readline().split(' '))


#A
for _ in range(I()):
    n,l = I(),[*RM()]
    if l[0]+l[1] <= l[-1]:
        print(1,2,n)
    else:
        print(-1)
    


