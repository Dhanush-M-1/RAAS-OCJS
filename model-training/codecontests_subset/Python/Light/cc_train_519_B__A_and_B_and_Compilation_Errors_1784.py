def _check(mp, pos):
    for ele in range(len(mp[pos + 1])):
        if mp[pos][ele] != mp[pos + 1][ele]:
            return mp[pos][ele]
    return mp[pos][-1]
            
            
def errors(mp):
    for pos in range(len(mp) - 1):
        print(_check(mp, pos))


def main():
    n = input()
    mp = dict()
    for i in range(3): 
        mp[i] = list(map(int, input().split()))
        mp[i].sort()
    errors(mp)
    
    
main()