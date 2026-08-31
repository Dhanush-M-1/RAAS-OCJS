a, ratio = map(int, input().split())
m = a
tot = a
while tot>=ratio>0:
    m = m + tot//ratio
    tot = tot//ratio + tot%ratio


print(m)