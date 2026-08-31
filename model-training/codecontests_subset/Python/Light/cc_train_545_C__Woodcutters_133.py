# dominos = [(1, 2), (2, 1), (5, 10), (10, 9), (20, 1)]
n = int(input())
dominos = []
for i in range(n):
    dom = input().split()
    dominos.append([int(dom[0]), int(dom[1])])

def knock(dominos):
    n = len(dominos)
    if n == 1:
        return 1

    max_dominos_fell = 2
    
    for i in range(1, len(dominos) - 1):
        x, h = dominos[i]
        if x - h > dominos[i - 1][0]:
            max_dominos_fell += 1
        elif x + h < dominos[i + 1][0]:
            max_dominos_fell += 1
            dominos[i][0] += h
    
    return max_dominos_fell
            
print(knock(dominos))