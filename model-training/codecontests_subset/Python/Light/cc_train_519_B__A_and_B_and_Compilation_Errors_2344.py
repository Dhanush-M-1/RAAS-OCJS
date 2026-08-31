n = int(input())
erros = [ int(x) for x in input().split() ]
erros2 = [ int(x) for x in input().split() ]
erros3 = [ int(x) for x in input().split() ]

erro1 = sum(erros) - sum(erros2)
erro2 = sum(erros2) - sum(erros3)

print(erro1)
print(erro2)