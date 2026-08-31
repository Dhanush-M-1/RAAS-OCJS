x = input().split()
x2 = input().split()
x[1] = int(x[1])

answer = 0

for i in range(len(x2)-1, -1, -1):
    x2[i] = int(x2[i])
    if x[1] % x2[i] == 0:
        if answer == 0:
            answer = int(x[1] / x2[i])
        else:
            temp = int(x[1] / x2[i])
            if temp < answer:
                answer = temp
print(int(answer))