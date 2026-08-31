def useful_sum_generator(sum):
    elements = list(sum.split("+"))
    sorted_elements =sorted(elements)
    count = 0
    for i in sorted_elements:
        count +=1
    c = 0
    useful_sum = []
    while c != count:
        if c == 0:
            useful_sum.append(sorted_elements[c])
            useful_sum.append("+")
        elif (count - 1) == c:
            useful_sum.append(sorted_elements[c])
        else:
            useful_sum.append(sorted_elements[c])
            useful_sum.append("+")
        c+=1
    return (''.join(useful_sum))


def main():
    sum = input()
    if (len(sum) == 1):
        print (sum)
    else:
        print(useful_sum_generator(sum))
main()