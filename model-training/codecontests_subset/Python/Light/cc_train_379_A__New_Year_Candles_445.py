a,b=map(int,input().split())

def light(wentOut,b):
    if wentOut<b:
        return 0
    newCandle=int(wentOut/b)
    left=wentOut%b
    return newCandle+light(newCandle+left,b)
print(a+light(a,b))
