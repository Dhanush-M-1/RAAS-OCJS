t=int(input())
while t>0:
    inp_int=int(input())
    inp=list(map(int, input().split()))
    if inp[0]+inp[1]<=inp[inp_int-1]:
        print(1,2,inp_int)
    elif inp[0]<=inp[inp_int-1]-inp[inp_int-2]:
        print(1,inp_int-1,inp_int)
    else:
        print(-1)
    t-=1