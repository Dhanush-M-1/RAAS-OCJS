a,b = map(int, input().split())
hours = 0
went_out = 0
while a > 0:
    hours += a
    went_out += a
    a = int(went_out/b)
    went_out = went_out % b

print(hours)