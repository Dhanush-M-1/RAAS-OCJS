st = input()
s = ""
sum1 = st.count("1") + st.count("2") + st.count("3")
one = st.count("1")
two = st.count("2") + one
three = st.count("3") + two

for i in range(sum1):
    if i < one:
        s += "1"
        if i == sum1 - 1:
            break
        else:
            s += "+"
    elif i < two:
        s += "2"
        if i == sum1 - 1:
            break
        else:
            s += "+"
    elif i < three:
        s += "3"
        if i == sum1 - 1:
            break
        else:
            s += "+"

print(s)
