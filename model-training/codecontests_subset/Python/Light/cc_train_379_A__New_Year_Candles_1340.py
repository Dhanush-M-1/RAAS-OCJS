a,b = map(int,input().split())
hourslit = a
oldcandles = a
while oldcandles >= b:
    q = oldcandles // b
    oldcandles -= q*(b-1)
    hourslit += q
print(hourslit)