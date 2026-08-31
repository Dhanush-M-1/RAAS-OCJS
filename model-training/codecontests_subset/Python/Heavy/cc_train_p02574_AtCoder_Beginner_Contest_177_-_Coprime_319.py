import sys
input = sys.stdin.buffer.readline

def main():
    N = int(input())
    a = list(map(int,input().split()))
    pr = [0]*(max(a)+1)
    flag = True
    for num in a:
        pr[num] += 1
    for i in range(2, max(a)+1):
        count = sum(pr[i::i])
        if count == N:
            print("not coprime")
            exit()
        elif count > 1:
            flag = False
    if flag:
        print("pairwise coprime")
    else:
        print("setwise coprime")

if __name__ == "__main__":
    main()
