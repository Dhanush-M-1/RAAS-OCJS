def solve():
    n = int(input())
    digits = input()
    c = digits.count("8")
    
    if c < 1 or n < 11:
        return 0
    
    return min(c, n // 11)
    
print (solve())

