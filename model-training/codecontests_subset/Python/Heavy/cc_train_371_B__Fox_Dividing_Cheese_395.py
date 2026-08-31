class Numero:
    def __init__(self, num):
        self.num = num
        self.qtd2 = self.func(num, 2)
        self.qtd3 = self.func(num, 3)
        self.qtd5 = self.func(num, 5)
        self.resto = num // (2**self.qtd2 * 3**self.qtd3 * 5**self.qtd5)
    def func(self, num, x):
        if num % x != 0:
            return 0
        else:
            return 1 + self.func(num//x, x)
    def getX(self):
        return self.qtd2 + self.qtd3 + self.qtd5

queijo_1, queijo_2 = map(int, input().split())
queijo_1 = Numero(queijo_1)
queijo_2 = Numero(queijo_2)

if queijo_1.resto == queijo_2.resto:
    x = 1
    x *= 2**min(queijo_1.qtd2, queijo_2.qtd2)
    x *= 3**min(queijo_1.qtd3, queijo_2.qtd3)
    x *= 5**min(queijo_1.qtd5, queijo_2.qtd5)
    n1 = Numero(queijo_1.num // (queijo_1.resto * x))
    n2 = Numero(queijo_2.num // (queijo_2.resto * x))
    ans = n1.getX() + n2.getX()
    print(ans)
else:
    print(-1)

