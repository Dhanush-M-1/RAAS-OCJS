# problem 2
def calc(N, index):
    # find the number when given (N,index)
    if index == 1 or index == N*(N-1)+1:
        return 1
    else:
        wave_l = 1
        wave_r = N
        while wave_r-wave_l > 1:
            M = (wave_l+wave_r)//2
            if (2*N-M)*(M-1) < index:
                wave_l = M
            else:
                wave_r = M
        wave = wave_l
        Left = index-(2*N-wave)*(wave-1)
        if Left % 2 != 0:
            return wave
        else:
            return wave+Left//2

    # maximum value := cnt
    Left = index-(cnt-1)*(cnt-2)
    if Left % 2 == 0:
        return cnt
    else:
        if cnt != Left//2+1:
            return Left//2+1
        else:
            return 1


def solve():
    n, l, r = map(int, input().split())
    A = []
    for i in range(l, r+1):
        A.append(calc(n, i))
    print(*A)


def main():
    T = int(input())
    for i in range(T):
        solve()


if __name__ == "__main__":
    main()