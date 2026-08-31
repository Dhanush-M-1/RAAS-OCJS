fn = {
    'lu': lambda x,y: [1,y],
    'ru': lambda x,y: [x,1],
    'ld': lambda x,y: [0,y],
    'rd': lambda x,y: [x,0]
}
while True:
    if input()=='0': break
    x,y = 0,0
    c,f = 0,1
    for s in input().split():
        x,y = fn[s](x,y)
        if x==y==f: c,f = c+1,abs(f-1)
    print(c)