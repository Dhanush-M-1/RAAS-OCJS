a,b = map(int,input().split())

def answer(a, b):
    if a < b:
        return (a)
    else:
        return (a - a % b + answer(int(a / b) + a % b, b))

print(int(answer(a,b)))

