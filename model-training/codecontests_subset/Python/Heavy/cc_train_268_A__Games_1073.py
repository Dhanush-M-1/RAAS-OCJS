def kits(n):

    teams = list(range(len(n)))
    result = 0
    for i in range(len(teams)):
        j = i
        while (j < len(teams)):
            
            if colors[i][0] == colors[j][1]:
                result += 1
            if colors[j][0] == colors[i][1]:
                result += 1
            
            j+= 1

    return result
    
if __name__ == '__main__':
    n = input()
    colors = {}
    for i in range(int(n)):
        colors[i] = input().split()
    print(kits(colors))
    