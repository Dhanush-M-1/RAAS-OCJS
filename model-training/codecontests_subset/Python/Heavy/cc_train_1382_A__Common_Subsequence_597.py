def sub_sequence_numbers(n, m, list_an, list_am):
    no = 0
    if n <= m:
        for i in list_an:
            if i in list_am:
                print("YES")
                print(1, i)
                no = 1
                break
                
        if no == 0:
            print("NO")
    else:
        for j in list_am:
            if j in list_an:
                print("YES")
                print(1, j)
                no = 1
                break
        if no == 0:
            print("NO")

t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    list_an = list(map(int, input().split()))
    list_am = list(map(int, input().split()))
    sub_sequence_numbers(n, m, list_an, list_am)
