

def Foo():
    n = int(input())
    m = n

    q_2 = 0
    while True:
        if (m % 2) == 0:
            m = m // 2
            q_2 += 1
        else:
            break
    q_3 = 0
    while True:
        if (m % 3) == 0:
            m = m // 3
            q_3 += 1
        else:
            break
        
    if m != 1 or q_2 > q_3:
        print(-1)
        return
    
    print((q_3 - q_2) + q_3)
    return

def main():
    t = int(input())

    for i in range(t):
        Foo()
    # for end
        
        


if __name__ == "__main__":
    main()