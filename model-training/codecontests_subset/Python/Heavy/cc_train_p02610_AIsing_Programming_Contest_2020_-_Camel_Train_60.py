import sys
import heapq
def input(): return sys.stdin.readline().rstrip()

def culc(li):
    li.sort(key=lambda x: x[1])
    h=[]
    for i in li:
        if len(h) >= i[1]:
            heapq.heappushpop(h, i[0])
        else:
            heapq.heappush(h, i[0])
    return sum(h)

def main():
    T=int(input())
    for _ in range(T):
        n=int(input())
        mae=[]
        ushiro=[]
        kijun=0
        for _ in range(n):
            k,l,r=map(int, input().split())
            if l>r:
                mae.append([l-r,k])
            else:
                ushiro.append([r-l,n-k])
            kijun+=min(l,r)
        print(culc(mae)+culc(ushiro)+kijun)
                    



if __name__ == '__main__':
    main()