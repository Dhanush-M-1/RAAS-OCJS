t = int(input())

for _ in range(t):
    input()
    l = [int(i) for i in input().split()]
    ok = False
    if sum(l[:2]) > l[-1]:
        # Se os menores dos lados podem combinar com o maior
        # para formar um triângulo "de verdade" (não degenerado),
        # então é impossível formar triângulo degenerado se se pode
        # usar todos os nºs disponíveis
        print(-1)
    else:
        # Triângulo é egenerado
        print(1, 2, len(l))