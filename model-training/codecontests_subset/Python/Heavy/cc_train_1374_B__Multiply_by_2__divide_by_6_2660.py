def solve_2(m):
    cnt=0
    if m==1:
        return 0
    while True:
        if m >= 6 and m%6==0:
            m = m//6
            cnt+=1
            if m == 1:
                return cnt
            elif m==6:
                return cnt+1
            elif m < 6:
                m*=2
                cnt+=1
                if m%6==0:
                    return cnt+1
                else:
                    return -1
        else:
            m*=2
            cnt+=1
            if m%6!=0:
                return -1

def main():
    t = int(input())
    for i in range(t):
        print(solve_2(int(input())))

main()