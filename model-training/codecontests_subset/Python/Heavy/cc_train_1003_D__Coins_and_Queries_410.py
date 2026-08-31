
def main():
 n,q = map(int,input().split())

 l = list(map(int,input().split()))
 from collections import defaultdict

 hash = defaultdict(int)
 for i in l:
    hash[i]+=1
 rd = []
 for i in range(30,-1,-1):
    rd.append(2<<i)
 final = []
 l = sorted(set(l))
 l.reverse()
 for i in range(q):
    z1 = int(input())
    ans = 0
    for i in l:

        d = min(hash[i],z1//(i))

        z1-=d*(i)
        ans+=d




    if z1 == 0:
        final.append(ans)
    else:
        final.append(-1)

 print(*final)

if __name__ == '__main__':
    main()