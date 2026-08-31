from itertools import count
q=(5,7,5,7,7)
while 1:
    l=[len(input()) for _ in range(int(input()))]
    for st in range(len(l)-4):
        c=0
        s=st
        for i in count(st):
            if c==5:break
            if sum(l[s:i])==q[c]:
                c+=1
                s=i
            elif sum(l[s:i])>q[c]:
                break
        if c==5:break 
    if len(l)>=5:
        print(st+1)    
    elif not l:
        break

