t = int(input())
for i in range(t):
    n = int(input())
    ip=[[0,0]]
    for j in range(n):
        ip.append(list(map(int,input().split())))
    prevplay,prevclear=ip[0]
    ok =  True
    for j in range(1,len(ip)):
        currplay,currclear=ip[j]
        if currplay<currclear or currplay<prevplay or currclear<prevclear or currplay-currclear<prevplay-prevclear:
            ok = False
            break
        prevplay,prevclear=currplay,currclear
    if(ok):
        print("YES")
    else:
        print("NO")
