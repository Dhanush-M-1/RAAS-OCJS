n = int(input())
l = list(map(int, input().split()))
l.sort()

odds = [o for o in l if o%2 == 1]
evens = [e for e in l if  e%2 == 0]

odds2 = [o for o in l if o%2 == 1]
evens2 = [e for e in l if  e%2 == 0]

flag = True
while len(odds)>=0 and len(evens)>=0:
    if flag:
        if len(odds)==0:
            break
        odds.pop()
    else:
        if len(evens)==0:
            break
        evens.pop()
    flag = not flag

flag = False
while len(odds2)>=0 and len(evens2)>=0:
    if flag:
        if len(odds2)==0:
            break
        odds2.pop()
    else:
        if len(evens2)==0:
            break
        evens2.pop()
    flag = not flag

print(min(sum(odds)+sum(evens),  sum(odds2)+ sum(evens2)) ) 
# print(min(sum(odds)+sum(evens),  sum(odds2)+ sum(evens2)) ) 
