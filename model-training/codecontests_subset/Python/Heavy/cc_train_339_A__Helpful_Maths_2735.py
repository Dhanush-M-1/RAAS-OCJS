strings = input()
lis = strings.split('+')
# convert the string numbers to integers
numbers = list(map(lambda x: int(x), lis))


def iterativesort(l):
    """input: a csv of numbers
      output: argument sorted in increasing order
   """
    for i in range(len(l)):
        for j in range(i + 1, len(l)):
            if l[j] < l[i]:
                t = l[j]
                l[j] = l[i]
                l[i] = t
    return l


numbers = iterativesort(numbers)
strings = list(map(lambda x: str(x), numbers))
print('+'.join(strings))
