def king(s):
    l = []
    for i in range(len(s)):
        if s[i] == '*':
            l.append(i)
    if len(l) < 5:
        print('no')
    else:
        k = (max(x for x in l)-min(x for x in l))//4
        def space_eq(s, j):
            ans = False
            for i in s:
                if (i+j) in s and (i+2*j) in s and (i+3*j) in s and (i+4*j) in s:
                    ans = True
                    break
            return ans
        ans = False
        for j in range(1, k+1):
            if space_eq(l, j) == True:
                ans = True
                break
        if ans == True:
            print('yes')
        else:
            print('no')

n = int(input())
s = input()
assert len(s) == n, 'Incorrect Input'
king(s)