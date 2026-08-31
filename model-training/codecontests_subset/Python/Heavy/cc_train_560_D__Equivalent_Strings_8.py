from sys import stdin
memo = dict()
def equiv(s1, s2):
    #print(s1, s2)
    if s1 == s2:
        #print(True)
        return True
    if len(s1) % 2 == 1: #odd true-equivalency considered in above clause
        return False
        #print(False)
    if (s1, s2) in memo:
        return memo[(s1, s2)]
    if equiv(s1[:int(len(s1)/2)], s2[:int(len(s2)/2)]) and equiv(s1[int(len(s1)/2):], s2[int(len(s2)/2):]):
        memo[(s1, s2)] = True
        #print(True)
        return True
    if equiv(s1[:int(len(s1)/2)], s2[int(len(s2)/2):]) and equiv(s1[int(len(s1)/2):], s2[:int(len(s2)/2)]):
        memo[(s1, s2)] = True
        #print(True)
        return True
    memo[(s1, s2)] = False
    #print(False)
    return False
a = stdin.readline().rstrip('\n')
b = stdin.readline().rstrip('\n')
if equiv(a, b):
    print("YES")
else:
    print("NO")
