
_=list(map(int,input().split()))
__=sorted(list(map(int,input().split())))
for ___ in range(_[0]-1,-1,-1):
    if _[1]%__[___]==0:
       print(_[1]//__[___])
       break


#ye jaye door bedoone IDE va net E :(