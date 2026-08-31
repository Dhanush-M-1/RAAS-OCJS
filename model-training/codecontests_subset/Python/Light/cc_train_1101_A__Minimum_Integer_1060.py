
q = int(input())


def find_next(a,d):

    if(a//d == a/d):
        return a+d
    else:

        x = a//d
        y = (x+1)*d

        return y



def check(l,r,d):

    for i in range(d,l,d):
        if(i%d==0):
            return i

    index = find_next(r,d)
    return index



for i in range(q):

    l,r,d = map(int, input().strip().split())

    print(check(l,r,d))









