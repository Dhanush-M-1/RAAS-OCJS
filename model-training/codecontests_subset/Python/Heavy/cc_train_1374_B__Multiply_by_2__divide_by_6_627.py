#   ==========     //\\       //||     ||====//||
#       ||        //  \\        ||     ||   // ||
#       ||       //====\\       ||     ||  //  ||
#       ||      //      \\      ||     || //   ||
#   ========== //        \\  ========  ||//====|| 
#  code

def main():
    t = int(input())
    for _ in range(t):
        n = int(input())
        if n == 1:
            print(0)
            continue
        cnt = 0
        while n % 3 == 0:
            cnt += 1
            n //= 3
        if cnt == 0:
            print(-1)
        else:
            cnt2 = 0
            while n % 2 == 0:
                cnt2 += 1
                n //= 2
            if cnt2 > cnt:
                print(-1)
            else:
                print(cnt2 + 2 * (cnt - cnt2) if n == 1 else -1)
    return

if __name__ == "__main__":
    main()