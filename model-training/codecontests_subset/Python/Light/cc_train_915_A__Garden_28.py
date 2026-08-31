cantidades = [int(x) for x in input().split()]
a = [int(i) for i in input().split()]


def divide(s):
    if(cantidades[1]%s == 0):
        return True
    else:
        return False


cand = filter(divide, a)
print(cantidades[1]//max(cand))
