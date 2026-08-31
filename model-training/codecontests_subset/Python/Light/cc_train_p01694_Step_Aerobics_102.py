while True:
    N = int(input())
    if N == 0: break
    src = list(input().split())
    ru = lu = both = False
    ans = 0
    for f in src:
       if f == 'ru':   ru = True
       elif f == 'lu': lu = True
       elif f == 'rd': ru = False
       else:           lu = False
       if ru == lu == (not both):
           ans += 1
           both = not both
    print(ans)