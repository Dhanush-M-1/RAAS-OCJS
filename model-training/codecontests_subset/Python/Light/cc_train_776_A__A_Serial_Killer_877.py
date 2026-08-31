text = []
text = input().split()
one = text[0]
two = text[1]
n = int(input())
print(one,two)
for x in range(n):
    text = input().split()
    if text[0] == one:
        one = text[1]
    elif text[0] == two:
        two = text[1]
    elif text[1] == one:
        one = text[0]
    elif text[1] == two:
        two = text[0]
    print(one,two)
        
