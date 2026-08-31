x = input()
c = 0
one = 0
two = 0
three = 0
while c < len(x):
    if x[c] == "1":
        one += 1
    elif x[c] == "2":
        two += 1
    else:
        three += 1
    c += 2
if one > 0 and two > 0 and three > 0:
    print("1" + ("+1" * (one - 1)) + "+2" + ("+2" * (two - 1)) + "+3" + ("+3" * (three - 1)))
elif one > 0 and two > 0 and three == 0:
    print("1" + ("+1" * (one - 1)) + "+2" + ("+2" * (two - 1)))
elif two > 0 and three > 0 and one == 0:
    print("2" + ("+2" * (two - 1)) + "+3" + ("+3" * (three - 1)))
elif two ==0 and three >0 and one > 0:
    print("1" + ("+1" * (one - 1)) + "+3" + ("+3" * (three - 1)))
elif two ==0 and three == 0 and one > 0:
    print("1" + ("+1" * (one - 1)))
elif two >0 and three ==0 and one ==0:
    print("2" + ("+2" * (two - 1)))
elif three >0 and two ==0 and one ==0:
    print("3" + ("+3" * (three - 1)))