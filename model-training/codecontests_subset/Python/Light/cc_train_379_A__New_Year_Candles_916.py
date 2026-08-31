a, b = map(int, input().split())

new = 0
burnt = a
hours = a

while burnt >= b:
    new = burnt//b
    hours += new
    burnt = new  + burnt%b

print(hours)




