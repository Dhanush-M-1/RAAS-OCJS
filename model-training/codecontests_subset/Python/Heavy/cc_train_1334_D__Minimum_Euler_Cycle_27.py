# import sys
# _INPUT_LINES = sys.stdin.read().splitlines()
# input = iter(_INPUT_LINES).__next__





def go():
    # n=int(input())
    n,l,r = map(int, input().split())
    # a = sorted(map(int, input().split()),reverse=True)
    tot = n*(n-1)+1
    add=[]
    if r==tot:
        add=['1']
        r-=1

    res=[]
    if l<=r:

        cur=0
        nextg=n-1
        while cur+2*nextg<l:
            cur+=2*nextg
            nextg-=1

        g=n-nextg
        shift=l-cur-1
        pair,par = divmod(shift,2)
        pair+=g+1

        while l<=r:
            if par==0:
                res.append(g)
                par+=1
            else:
                res.append(pair)
                par=0
                if pair<n:
                    pair+=1
                else:
                    g+=1
                    pair=g+1
            l+=1

    res = res+add
    return ' '.join(map(str,res))


# x,s = map(int,input().split())
t = int(input())
# t = 1
ans = []
for _ in range(t):
    # print(go())
    ans.append(str(go()))
#
print('\n'.join(ans))
