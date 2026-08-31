import collections

entrada = input().split("+",)
vector_salida=[]

contador = collections.Counter(entrada)

if contador[1]+contador[2]+contador[3] == 1:
    salida = contador["1"]*"1"+contador["2"]*"2"+contador["3"]*"3"
else:
    for j in range(0,len(entrada)):
        if j < len(entrada):
            if j < contador["1"]:
                if j==0:
                    salida = "1"
                else:
                    salida = salida + "+" + "1"
            if j >= contador["1"] and j < contador["2"]+contador["1"]:
                if j==0:
                    salida = "2"
                else:
                    salida = salida + "+" +"2"
            if j >= contador["1"]+contador["2"] and j < contador["1"]+contador["2"]+contador["3"]:
                if j==0:
                    salida = "3"
                else:
                    salida = salida + "+" + "3"
  


print(salida)