import sys

__author__ = 'Obriel Muga'

lista = list()
    

if __name__ == '__main__':
    d = dict()
    valor = 0
    for line in sys.stdin:
        command = line
        if (command[0] == '+'):
            name = command.strip().split('+')[1]
            d[name] = 1
        elif (command[0] == '-'):
            name = command.strip().split('-')[1]
            del d[name]
        elif (':' in command):
            nombre,mensaje = command.strip().split(':')
            valor = valor + len(d)*len(mensaje)
    print(valor)
            

            

    
