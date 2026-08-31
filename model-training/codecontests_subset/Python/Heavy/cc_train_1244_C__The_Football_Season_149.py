n,p,w,d=map(int,input().split())

#n the number of games
#p the number of points
#w points awarded for winning
#d points awarded for a draw

#impossible if n*w < p
#for p = 10,w = 3,d = 2?
def canDraw(p,w,d):
    dcounter = 0
    if w % d == 0 and p%d != 0:
        dcounter =0

    else:
        while p %w !=0:
            p -= d
            dcounter +=1

    return dcounter

if n*w >= p:
    dcounter = int(canDraw(p,w,d))
    wcounter= int((p - dcounter*d)/w)
    lcounter = int(n - dcounter -wcounter)

    if wcounter < 0 or dcounter <0 or lcounter <0 or wcounter*w + dcounter*d != p:
        print(-1)
    else:
        print(wcounter,dcounter,lcounter)


else:
    print(-1)