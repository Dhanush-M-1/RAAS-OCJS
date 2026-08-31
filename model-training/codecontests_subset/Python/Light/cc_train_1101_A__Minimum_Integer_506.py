for i in range(int(input())):
    l , r , d = map(int, input().split())
    if d<l:
        print(d)
    else:
        temp = (r+d)%d
        temp = (r+d)-temp
        print(temp)