n,k = map(int,input().split())
inf = float("inf")
a,b,c = [inf],[inf],[inf]
a_cnt,b_cnt = 0,0
for i in range(n):
    u,v,w = map(int,input().split())
    if v==1 and w==1:
        c.append(u)
        a_cnt += 1; b_cnt +=1
    elif v==1:
        a.append(u)
        a_cnt += 1
    elif w==1:
        b.append(u)
        b_cnt += 1
if a_cnt < k or b_cnt < k:
    print(-1)
    exit()
a.sort(reverse=True)
b.sort(reverse=True)
c.sort(reverse=True)
a_left,b_left,ans = k,k,0
while a_left > 0 or b_left > 0:
    if a_left and b_left and len(a)-1 and len(b)-1 and len(c)-1:
        if (a[-1] + b[-1]) >= c[-1] or len(a)-1 < a_left or len(b)-1 < b_left:
            ans += c.pop()
        else:
            ans += a.pop() + b.pop()
        a_left-=1;b_left-=1
    else:
        best = inf
        if a_left and b_left:
            best = min(best,a[-1]+b[-1])
        if a_left and not b_left:
            best = min(best,a[-1])
        if b_left and not a_left:
            best = min(best,b[-1])
        best = min(best,c[-1])
        if best == c[-1]:
            ans += c.pop()
            a_left-=1;b_left-=1
        elif best == a[-1]:
            ans += a.pop()
            a_left -=1
        else:
            ans += b.pop()
            b_left-=1
print(ans)            
