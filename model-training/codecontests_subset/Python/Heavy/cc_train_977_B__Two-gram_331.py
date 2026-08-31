def count(strs):    
    if len(strs) <= 2:
        return strs
    
    dicts = {}
    for i in range(len(strs) - 1):
        #print(strs[i] + strs[i + 1])
        if strs[i] + strs[i + 1] in dicts:
            dicts[strs[i] + strs[i + 1]] += 1
        else:
            dicts[strs[i] + strs[i + 1]] = 0

    max  = 0
    gram = ""
    
    for i in dicts:
        if dicts[i] >= max:
            max = dicts[i]
            gram = i
    
    return gram



def main():
    n = input()
    st = input()
    print(count(st))
main()

        
