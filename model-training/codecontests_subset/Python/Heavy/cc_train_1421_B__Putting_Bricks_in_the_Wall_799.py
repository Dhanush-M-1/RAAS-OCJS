import sys
import collections
input = sys.stdin.readline


def main():
    t = int(input())
    for _ in range(t):
        N = int(input())
        S = [input() for _ in range(N)]

        if S[0][1] == "0" and S[1][0] == "0" and S[N - 1][N - 2] == "0" and S[N - 2][N - 1] == "0":
            print(2)
            print(1, 2)
            print(2, 1)
        if S[0][1] == "0" and S[1][0] == "0" and S[N - 1][N - 2] == "0" and S[N - 2][N - 1] == "1":
            print(1)
            print(N, N - 1)
        if S[0][1] == "0" and S[1][0] == "0" and S[N - 1][N - 2] == "1" and S[N - 2][N - 1] == "0":
            print(1)
            print(N - 1, N)
        if S[0][1] == "0" and S[1][0] == "0" and S[N - 1][N - 2] == "1" and S[N - 2][N - 1] == "1":
            print(0)
        if S[0][1] == "0" and S[1][0] == "1" and S[N - 1][N - 2] == "0" and S[N - 2][N - 1] == "0":
            print(1)
            print(1, 2)
        if S[0][1] == "0" and S[1][0] == "1" and S[N - 1][N - 2] == "0" and S[N - 2][N - 1] == "1":
            print(2)
            print(1, 2)
            print(N - 1, N)
        if S[0][1] == "0" and S[1][0] == "1" and S[N - 1][N - 2] == "1" and S[N - 2][N - 1] == "0":
            print(2)
            print(1, 2)
            print(N, N - 1)
        if S[0][1] == "0" and S[1][0] == "1" and S[N - 1][N - 2] == "1" and S[N - 2][N - 1] == "1":
            print(1)
            print(2, 1)
        if S[0][1] == "1" and S[1][0] == "0" and S[N - 1][N - 2] == "0" and S[N - 2][N - 1] == "0":
            print(1)
            print(2, 1)
        if S[0][1] == "1" and S[1][0] == "0" and S[N - 1][N - 2] == "0" and S[N - 2][N - 1] == "1":
            print(2)
            print(2, 1)
            print(N - 1, N)
        if S[0][1] == "1" and S[1][0] == "0" and S[N - 1][N - 2] == "1" and S[N - 2][N - 1] == "0":
            print(2)
            print(2, 1)
            print(N, N - 1)
        if S[0][1] == "1" and S[1][0] == "0" and S[N - 1][N - 2] == "1" and S[N - 2][N - 1] == "1":
            print(1)
            print(1, 2)
        if S[0][1] == "1" and S[1][0] == "1" and S[N - 1][N - 2] == "0" and S[N - 2][N - 1] == "0":
            print(0)
        if S[0][1] == "1" and S[1][0] == "1" and S[N - 1][N - 2] == "0" and S[N - 2][N - 1] == "1":
            print(1)
            print(N - 1, N)
        if S[0][1] == "1" and S[1][0] == "1" and S[N - 1][N - 2] == "1" and S[N - 2][N - 1] == "0":
            print(1)
            print(N, N - 1)
        if S[0][1] == "1" and S[1][0] == "1" and S[N - 1][N - 2] == "1" and S[N - 2][N - 1] == "1":
            print(2)
            print(1, 2)
            print(2, 1)






        
    

if __name__ == '__main__':
    main()


