def good(s):
    if not s:
        return True
    if s.count('1') != s.count('0'):
        return True

    return False

def main():
    n = int(input())
    s = input()
    s1 = list(s)
    s2 = []
    for i in range(n):
        if good(s1) and good(s2):
            break
        s2.insert(0,s1.pop())

    sx1 = ''
    for i in s1:
        sx1 += i

    sx2 = ''
    for i in s2:
        sx2 += i

    if not sx2:
        print(1)
        print(sx1)
        return
    print(2)
    print(sx1,sx2)


main()
