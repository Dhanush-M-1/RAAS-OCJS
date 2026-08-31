t = int(input())
l1 = [int(x) for x in input().split()]
l1.sort(reverse=True)

odds =len([1 for x in l1 if x%2])
evens=len(l1)-odds

if evens>odds:
    temp = odds
    odds = evens
    evens = temp
odds = min(odds,evens+1)
odds1=odds
evens1=evens
l2 = l1.copy()
for x in l1:
    if x%2 and odds:
        l1[l1.index(x)]=0
        odds-=1
    elif x%2==0 and evens:
        l1[l1.index(x)]=0
        evens-=1
odds = odds1
evens = evens1
for x in l2:
    if x%2 and evens:
        l2[l2.index(x)]=0
        evens-=1
    elif x%2==0 and odds:
        l2[l2.index(x)]=0
        odds-=1

#print(l1,l2)

print(min(sum(l1),sum(l2)))



