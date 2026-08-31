import sys

def Main():
    writer = sys.stdout.write
    expr = input()
    x1 = 0
    x2 = 0
    x3 = 0
    for i in range(len(expr)):
        if expr[i] == '1':
            x1+=1
        if expr[i] == '2':
            x2+=1
        if expr[i] == '3':
            x3+=1
    
    while x1+x2+x3 > 0:
        if x1 > 0:
            writer("1")
            x1-=1
        elif x2 > 0:
            writer("2")
            x2-=1
        elif x3 > 0:
            writer("3")
            x3-=1

        if x1+x2+x3 > 0:
            writer("+")

if __name__ == "__main__":
    Main()
