#for line in archivo:   line.split() imprime linea a linea en lista
#res=[x + y for x in lista for y in lista1] similar a bucle for. Permuta los items de cada lista..
#separador = ""  para separar alternando argumentos


def crear_archivo():
    archivo=open("archivo_de_práctica", "w")
    archivo.close

def escribir_archivo():
    archivo=open("agenda.nro1", "a")
    cadena=input("introducir nombre de archivo")
    archivo.write(cadena)
    archivo.close

entrada = input()
lista=list()

a=entrada.replace("+", "")


for numeros in a:
    lista.append(numeros)

lista.sort()
string="+".join(lista)

print(string)