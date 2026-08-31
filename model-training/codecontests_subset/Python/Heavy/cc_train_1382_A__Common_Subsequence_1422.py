import math as mt
def tran(ar1,ar2):
    an=[]
    for i in ar1:
        if i in ar2:
            an.append("YES")
            break
    if len(an)==1:
        an.append(1)
        an.append(i)
    else:
        an.append("NO")
    return an
if __name__ == '__main__':
    t = int(input())
    ans = []
    for i in range(t):
        nm = list(map(int, input().rstrip().split()))
        ar1 = list(map(int, input().rstrip().split()))
        ar2 = list(map(int, input().rstrip().split()))
        r = tran(ar1,ar2)
        ans.append(r)
    for i in ans:
        if len(i)==3:
            print(i[0])
            i.pop(0)
            print(*i)
        else:
            print("NO")




