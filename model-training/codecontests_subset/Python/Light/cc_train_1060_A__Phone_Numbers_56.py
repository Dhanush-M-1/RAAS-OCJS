x = int(input())
y = input()
a = x // 11
m = [d for d in y]
t = m.count("8")

if m.count("8") >= a:
    print(a)
elif t <= a and len(y) >= (11* t) and t !=0 :
    print(t)
else:
    print("0")