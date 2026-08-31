def solution(entrada):
    x = entrada[2]
    jump = False
    while (x % entrada[2] != 0) or (x >= entrada[0] and x <= entrada[1]):
        if (x >= entrada[0] and x <= entrada[1]) and jump == False:
            x += int((entrada[1] - entrada[0]) / entrada[2]) * entrada[2]
            jump = True
        else:
            x += entrada[2]
    print(x)

n_entradas = int(input())
entradas = []
for i in range(n_entradas):
    entradas.append(list(map(int,input().split(" "))))

for entrada in entradas:
    solution(entrada)