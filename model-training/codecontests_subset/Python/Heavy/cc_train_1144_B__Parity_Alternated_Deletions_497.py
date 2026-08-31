n = int(input())
ar = list(map(int, input().split()))

total = sum(ar)

chet = sorted([x for x in ar if x % 2 == 0],reverse=True)
nechet = sorted([x for x in ar if x % 2 != 0],reverse=True)

idx1 = 0
idx2 = 0
op = 'chet'
while idx1 < len(chet) and idx2 < len(nechet):
    total -= chet[idx1]
    op='nechet'
    total -= nechet[idx2]
    op='chet'
    
    idx1 += 1
    idx2 += 1
    
if op == 'chet' and idx1 < len(chet):
    total -= chet[idx1]
if op == 'nechet' and idx2 < len(nechet):
    total -= nechet[idx2]
    
min_tot = total
total = sum(ar)

op = 'nechet'
idx1 = 0
idx2 = 0

while idx1 < len(chet) and idx2 < len(nechet):
    total -= nechet[idx2]
    op='chet'
    
    total -= chet[idx1]
    op='nechet'

    
    idx1 += 1
    idx2 += 1
    
#print(idx1, idx2)
    
if op == 'chet' and idx1 < len(chet):
    total -= chet[idx1]
if op == 'nechet' and idx2 < len(nechet):
    total -= nechet[idx2]
    
print(min(min_tot, total))