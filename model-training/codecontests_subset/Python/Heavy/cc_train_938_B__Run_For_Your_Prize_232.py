def check1(a):
    for i in a:
        if i >500000.5:
            return False
    return True

def check2(a):
    for i in a:
        if i < 500000.5:
            return False
    return True

def answer(a,n):
    m = 500000.5
    if check1(a):
        print (a[-1]-1)
        return
    elif check2(a):
        print (1000000-a[0])
        return
    else:
        i = 0
        while True:
            if a[i]<m and a[i+1]>m:
                break
            i += 1
        if a[i+1]-m > m- a[i]:
            print (a[i] - 1)
        else:
            print (1000000 - a[i+1])
n = int(input())
a = list(map(int, input().split()))
answer(a, n)