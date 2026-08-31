def get_hours(n, b, remaining):
    if n + remaining < b:
        return n
    else:
        return n + get_hours((n + remaining) // b, b, (n + remaining) % b)


a, b = map(int, input().split())
print(get_hours(a, b, 0))