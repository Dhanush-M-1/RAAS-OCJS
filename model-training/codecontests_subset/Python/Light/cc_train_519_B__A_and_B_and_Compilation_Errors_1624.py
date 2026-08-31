

def diferencia(primero, segundo):
    primero.sort()
    segundo.sort()
    for i in range(len(segundo)):
        if(primero[i] != segundo[i]): return primero[i]

    return primero[-1]

if __name__ == "__main__":
    input()
    primero = [int(j) for j in input().split(' ')]
    segundo = [int(j) for j in input().split(' ')]
    tercero = [int(j) for j in input().split(' ')]

    print(diferencia(primero, segundo))
    print(diferencia(segundo, tercero))