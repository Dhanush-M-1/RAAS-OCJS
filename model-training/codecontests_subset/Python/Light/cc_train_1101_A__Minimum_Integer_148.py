def ii():
    return int(input())
def mi():
    return map(int,input().split())
def li():
    return list(mi())


for _ in range(ii()):
    a,b,d=mi()
    if (d>b or d<a):
        print(d)
    else:
        print((b//d+1)*d)