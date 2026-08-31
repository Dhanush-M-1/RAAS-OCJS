def test(n, string):
    eight = string.count('8')
    n = n //11
    if eight >= n:
        return n
    else:
        return eight



print(test(int(input()), input()))