a, b = input().split()
a, b = int(a),int(b)
s = a
while int(a/b):
    s +=int(a/b)
    a = int(a/b) + a%b
print(s)

        
