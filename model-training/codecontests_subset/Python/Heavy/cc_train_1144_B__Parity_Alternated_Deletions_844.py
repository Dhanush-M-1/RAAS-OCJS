amount = int(input())

all_numbers = map(int, input().split())
even = []
odd = []

for element in all_numbers:
    if element % 2:
        odd.append(element)
    else:
        even.append(element)

even.sort()
odd.sort()


def good(even, odd):
    even_cpy = even[:]
    odd_cpy = odd[:]
    alter = True
    flag = True
    #breakpoint()
    while flag:
        if alter:
            if len(odd) > 0:
                odd.pop()
            else:
                flag = False
                if len(odd_cpy) > 0:
                    odd_cpy.pop()
            if len(even_cpy) > 0:
                even_cpy.pop()
            else:
                flag = False
                if len(even) > 0:
                    even.pop()
            alter = not alter
        else:
            if len(even) > 0:
                even.pop()
            else:
                flag = False
                if len(even_cpy) > 0:
                    even_cpy.pop()
            if len(odd_cpy) > 0:
                odd_cpy.pop()
            else:
                flag = False
                if len(odd) > 0:
                    odd.pop()
            alter = not alter
    
    return min(sum(even)+sum(odd), sum(even_cpy)+sum(odd_cpy))


if len(odd) == 0:
    print(sum(even)-max(even))
elif len(even) == 0:
    print(sum(odd)-max(odd))
else:
    print(good(even, odd))
