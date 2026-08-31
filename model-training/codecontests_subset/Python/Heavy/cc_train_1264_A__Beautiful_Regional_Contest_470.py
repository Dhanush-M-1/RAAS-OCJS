from collections import OrderedDict
t = int(input())
while(t>0):
    n = int(input())
    a =[int(i) for i in input().split()]
    k = a[-1]
    d = OrderedDict()
    for i in a:
        if i not in d:
            d[i]=1
        else:
            d[i]+=1
    last = d[k]
    c = len(d.keys())
    prize = n//2
    if c>=4:
        n = n-last
        if n>3:
            g = d[a[0]]
            total = g
            s=0
            b = 0
            for i in d.keys():
                if i==a[0]:
                    pass
                else:
                    total+=d[i]
                    if s<=g and total<=prize and i!=k:
                        s+=d[i]
                    elif total<=prize and i!=k:
                        b+=d[i]
            if g<s and g<b:
                print(g,s,b)
            else:
                print('0 0 0')
        else:
            print('0 0 0')
    else:
        print('0 0 0')
    t-=1