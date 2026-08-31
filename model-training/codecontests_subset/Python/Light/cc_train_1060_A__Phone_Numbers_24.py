def phone_numbers(s, n):
    return min(s.count('8'), n // 11)


m = int(input())
t = input()
print(phone_numbers(t, m))
