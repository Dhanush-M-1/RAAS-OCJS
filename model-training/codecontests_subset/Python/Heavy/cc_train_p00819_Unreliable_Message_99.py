def decode(mes,command):
    if command == 'J':
        return mes[-1] + mes[:-1]
    elif command == 'C':
        return mes[1:] + mes[0]
    elif command == 'E':
        m = len(mes)//2
        if len(mes)%2 == 0:
            return mes[m:] + mes[:m]
        else:
            return mes[m+1:] + mes[m] + mes[:m]
    elif command == 'A':
        return mes[::-1]
    else:
        d = (-1 if command == 'P' else 1)
        ret = ''
        for c in mes:
            if c.isdigit():
                ret += str((int(c)+d) % 10)
            else:
                ret += c
        return ret

N = int(input())
for i in range(N):
    order,mes = input(),input()
    for c in reversed(order):
        mes = decode(mes,c)
    print(mes)