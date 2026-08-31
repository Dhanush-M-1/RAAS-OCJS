def task_B():
    t = int(input())
    for _ in range(t):
        n = int(input())
        if n == 1:
            print(0)
        elif n % 3 != 0:
            print(-1)
        else:
            curr_n = n
            div_2 = 0
            div_3 = 0
            while curr_n % 2 == 0:
                div_2 += 1
                curr_n /= 2
            while curr_n % 3 == 0:
                div_3 += 1
                curr_n /= 3
            if curr_n != 1:
                print(-1)
            else:
                if div_3 == div_2:
                    print(div_3)
                elif div_3 > div_2:
                    print(div_3 + div_3 - div_2)
                else:
                    print(-1)



def main():
    task_B()

if __name__ == '__main__':
    main()