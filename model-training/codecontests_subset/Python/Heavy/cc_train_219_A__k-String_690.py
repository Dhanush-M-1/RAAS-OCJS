def ans(k, s):
    b, dic = check(k, s)
    if not b:
        return -1
    a = []
    x = []
    for num in dic:
        a.append(num)
        x.append(dic[num]//k)
    
    l = formation(a, x)
    return l*k
    pass

def formation(a, x):
    ans = []
    for i in range(len(a)):
        ans.append(a[i]*x[i])
    
    return ''.join(ans)

def check(n, s):
    d = dict()
    for i in range(len(s)):
        if s[i] not in d:
            d[s[i]] = 1
        else:
            d[s[i]] +=1
    
    for num in d:
        if d[num]%n is not 0:
            return False, d
    
    return True, d

n = int(input())
s = str(input())

print(ans(n, s))