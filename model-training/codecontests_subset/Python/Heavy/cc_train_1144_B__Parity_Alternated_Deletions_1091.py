n = int(input())
arr = list(map(int,input().split()))
evens,odds = [],[]
for i in arr:
    if i%2 == 0:
        evens.append(i)
    else:
        odds.append(i)

evens.sort(reverse = True)
odds.sort(reverse=True)

if len(evens)>=len(odds):
    while evens and odds:
        evens.pop(0)
        odds.pop(0)

    if len(odds) == 0:
        e = 0 if len(evens)==0 else evens.pop(0)
        summ = sum(evens) if len(evens)>0 else 0
        print(summ)
    else:
        summ = sum(evens) if len(evens)>0 else 0
        summ += sum(odds) if len(odds)>0 else 0
        print(summ)

else:    
    while evens and odds:
        odds.pop(0)
        evens.pop(0)
    if len(evens) == 0:
        e = 0 if len(odds)==0 else odds.pop(0)
        summ = sum(odds) if len(odds)>0 else 0
        print(summ)
    else:
        summ = sum(evens) if len(evens)>0 else 0
        summ += sum(odds) if len(odds)>0 else 0
        print(summ)