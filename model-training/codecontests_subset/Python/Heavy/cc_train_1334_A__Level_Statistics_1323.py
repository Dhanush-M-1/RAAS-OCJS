for _ in range(int(input())):
    am = int(input())
    a,b = list(map(int,input().split()))
    arr = []
    if a < b:
        for g in range(am - 1):
            a = input()
        print("NO")
        continue
    for i in range(am-1):
        a1,b1 = list(map(int,input().split()))
        if (a1-a < b1-b or a1 < a or b1 < b):
            print("NO")
            for g in range(am-(i+2)):
                a = input()
            break
        a = a1
        b = b1
    else:
        print("YES")
