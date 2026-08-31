n,k = map(int, input().split())
a,b,ab = [],[],[]
for _ in range(n):
    t,x,y = map(int, input().split())
    if x==1 and y==1: ab.append(t)
    elif x==1 and y==0: a.append(t)
    elif x==0 and y==1: b.append(t)

if len(ab)+min(len(a),len(b))<k: print(-1)
else:
    cost, ind, tog = 0,0,0
    a.sort()
    b.sort()
    ab.sort()
    for i in range(k):
        if tog==len(ab):
            cost += sum(a[ind:ind+(k-i)]) + sum(b[ind:ind+(k-i)])
            break
        elif ind==min(len(a),len(b)):
            cost += sum(ab[tog:tog+(k-i)])
            break
        else:
            if a[ind]+b[ind]<ab[tog]:
                cost += a[ind]+b[ind]
                ind+=1
            else:
                cost += ab[tog]
                tog+=1
    print(cost)









