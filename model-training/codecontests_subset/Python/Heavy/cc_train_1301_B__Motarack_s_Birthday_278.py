import math
def main():
    t = int(input())
    for i in range(t):
        n = int(input())
        a = list(map(int,input().split()))
        mina,maxa = 10**9,-1
        m,k = 0,0
        if set(a) == set([-1]):
            m,k = 0,42
        else:
            for j in range(n):
                if a[j] == -1:
                    if j-1 >= 0:
                        tmp = a[j-1]
                        if tmp != -1:
                            mina = min(mina,tmp)
                            maxa = max(maxa,tmp)
                    if j+1 < n:
                        tmp = a[j+1]
                        if tmp != -1:
                            mina = min(mina,tmp)
                            maxa = max(maxa,tmp)
                else:
                    if j-1 >= 0:
                        if a[j-1] != -1:
                            m = max(m,abs(a[j]-a[j-1]))
                    if j+1 < n:
                        if a[j+1] != -1:
                            m = max(m,abs(a[j]-a[j+1]))
            k = math.ceil((mina+maxa)/2)
            m = max(m,abs(maxa-k),abs(k-mina))
        print(m,k)

if __name__ == '__main__':
    main()