import sys
input = sys.stdin.readline

def main():
    tes = int(input())
    for testcase in [0]*tes:
        n,m = map(int,input().split())
        new = [True]*(3*n)
        res = []

        for i in range(1,m+1):
            u,v = map(int,input().split())
            if new[u-1] and new[v-1]:
                if len(res) < n:
                    res.append(i)
                    new[u-1] = new[v-1] = False

        
        if len(res) >= n:
            print("Matching")
            print(*res)
        else:
            vs = []
            for i in range(3*n):
                if new[i]:
                    vs.append(i+1)
                    if len(vs) >= n:
                        break
            print("IndSet")
            print(*vs)

if __name__ == '__main__':
    main()