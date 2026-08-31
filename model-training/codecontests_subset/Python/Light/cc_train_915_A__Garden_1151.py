#   ==========     //\\       //||     ||====//||
#       ||        //  \\        ||     ||   // ||
#       ||       //====\\       ||     ||  //  ||
#       ||      //      \\      ||     || //   ||
#   ========== //        \\  ========  ||//====|| 
#  code

def solve():
    n, k = map(int, input().split())
    a = list(map(int, input().split()))

    a.sort()
    ans = float('inf')
    for i in a:
        if k % i == 0:
            ans = min(ans, k // i)
    print(ans)

def main():
    t = 1
    # t = int(input())
    for _ in range(t):
        solve()

if __name__ == "__main__":
    main()