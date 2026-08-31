import sys
read = sys.stdin.buffer.read
readline = sys.stdin.buffer.readline
readlines = sys.stdin.buffer.readlines
import heapq

def _solve(N, _list):
    n = len(_list)
    # Kの昇順
    _list.sort(key=lambda x: x[0])
    
    # まず、最低限得られるうれしさを求める
    base_score = sum([x[2] for x in _list])

    ni = 0
    S = []
    for j in range(N+1):
        # Ki = j であるラクダをSに追加
        while ni < n and _list[ni][0] == j:
            _, L, R = _list[ni]
            heapq.heappush(S, L - R)
            ni += 1
        # len(S) > j である場合、増えるうれしさの小さいものを削除する
        while len(S) > j:
            heapq.heappop(S)

    return base_score + sum(S)# + sum([x[1]-x[2] for x in _list[ni:]])

def solve(N, KLR):
    BigL = [] # L の方が大きいやつ
    BigR = [] # R の方が大きいやつ

    for i in range(N):
        K, L, R = KLR[3*i], KLR[3*i+1], KLR[3*i+2]
        # L の方が大きいやつと、 Rの方が大きいやつに分けて考える
        if L < R:
            # R の方が大きいやつは、LとRを逆転させて、
            # Lの方が大きいやつと同じように考えられるようにする
            BigR.append((N-K, R, L))
        else:
            # 番号が0から始まるようにする
            BigL.append((K, L, R))

    return _solve(N, BigL) + _solve(N, BigR)
        
def main():
    T, *_all = map(int, read().split())
    n = 0

    ans = []
    for _ in range(T):
        N = _all[n]
        KLR = _all[n+1:n+1+3*N]
        ans.append(solve(N, KLR))
        n += 1 + 3*N

    print(*ans, sep='\n')

if __name__ == '__main__':
    main()