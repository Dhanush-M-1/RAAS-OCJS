def reorganizeStr(string):
    if len(string) % 2 == 1: 
        return string
    
    mid = len(string) // 2
    
    part1 = reorganizeStr(string[:mid])
    part2 = reorganizeStr(string[mid:])
    
    if part1 < part2:
        return part1 + part2
    
    return part2 + part1

def isEquivalent(a, b, tam):
    a = reorganizeStr(a)
    b = reorganizeStr(b)

    return a == b
    
def run():
    str1 = input()
    str2 = input()

    if (isEquivalent(str1, str2, len(str1))):
        print('YES')
    else:
        print('NO')

run()