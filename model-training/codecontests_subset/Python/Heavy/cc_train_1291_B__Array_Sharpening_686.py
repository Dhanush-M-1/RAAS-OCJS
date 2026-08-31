T = n = 0

def get_mark(a):
    mark = []
    for i in range(n):
        if a[i] >= i:
            if i > 0 and not mark[i - 1]:
                mark.append(False)
            else:
                mark.append(True)
        else:
            mark.append(False)
    return mark
def judge(a):
    mark1 = get_mark(a)
    a.reverse()
    mark2 = get_mark(a)
    mark2.reverse()
    for i in range(n):
        mark1[i] = mark1[i] and mark2[i]
    tmp = [x for x in mark1 if x]
    if tmp:
        return True
    else:
        return False

if __name__ == '__main__':
    T = int(input())
    while T > 0:
        a = []
        n = int(input())
        a = list(map(int,input().split()))
        if judge(a):
            print('Yes')
        else:
            print('No')
        T -= 1