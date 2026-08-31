from sys import *

def resolve(t):
    N = int(stdin.readline().rstrip())
    array = [int(x) for x in stdin.readline().rstrip().split()]

    #dk: c < a + b , c lon nhat
    a = array[0]
    b = array[1]
    c = array[N-1]

    if (c >= a + b):
        print(str(1) + " " + str(2) + " " + str(N))
        return

    print("-1")


if __name__ == "__main__":
    T = int(stdin.readline().rstrip())
    for t in range(T):
        resolve(t)
    pass
