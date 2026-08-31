t = int(input())
Ans = []
for i in range(t):
    n = int(input())
    a = b = 0
    temp_1, temp_2 = map(int, input().split())
    for j in range(n - 1):
        flag = 1
        x_1, x_2 = map(int, input().split())
        if temp_1 < x_1 <= temp_2:
            temp_1 = x_1
            if x_1 > b != 0:
                b = x_1
        elif x_2 < temp_1:
            if x_2 < a or a == 0:
                a = x_2
            if temp_1 > b or b == 0:
                b = temp_1
            flag = 0
        if temp_1 <= x_2 < temp_2 and flag:
            temp_2 = x_2
            if x_2 < a:
                a = x_2
        elif x_1 > temp_2 and flag:
            if temp_2 < a or a == 0:
                a = temp_2
            if x_1 > b or b == 0:
                b = x_1
    Ans.append(b - a)
for k in Ans:
    print(k)