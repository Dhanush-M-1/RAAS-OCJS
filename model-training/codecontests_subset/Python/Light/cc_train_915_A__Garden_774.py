r = lambda: map(int,input().split())
b,g = r()
buck = sorted(list(r()),reverse = True)
for x in buck:
    if not g%x:
        print (g//x)
        break
