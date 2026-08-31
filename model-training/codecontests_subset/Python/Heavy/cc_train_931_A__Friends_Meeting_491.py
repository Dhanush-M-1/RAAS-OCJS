
class Amigo:
    def __init__(self, posicao, direcao):
        self.posicao = int(posicao)
        self.cansaco_passo = 0
        self.cansaco_total = 0
        self.direcao = direcao

    def move(self):
        self.cansaco_passo += 1
        if self.direcao == -1:
            self.posicao -= 1
        else:
            self.posicao += 1
        self.cansaco_total += self.cansaco_passo


a = int(input())
b = int(input())
if a < b:
    direcao_a = 1
    direcao_b = -1
else:
    direcao_a = -1
    direcao_b = 1

amigo_1 = Amigo(a, direcao_a)
amigo_2 = Amigo(b, direcao_b)

aux = 0
while amigo_1.posicao != amigo_2.posicao:
    if aux % 2 == 0:
        amigo_1.move()
    else:
        amigo_2.move()
    aux += 1

cansaco = amigo_1.cansaco_total + amigo_2.cansaco_total
print(cansaco)