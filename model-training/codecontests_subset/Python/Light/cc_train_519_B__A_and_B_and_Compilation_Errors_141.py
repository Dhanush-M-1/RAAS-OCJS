def print_error(list1, list2):
    i = 0
    try:
        while list1[i] == list2[i]:
            i += 1
    except:
        pass
    print(list1[i])

n = int(input())
a = [int(x) for x in input().split()]
b = [int(x) for x in input().split()]
c = [int(x) for x in input().split()]

a.sort()
b.sort()
c.sort()

print_error(a, b)
print_error(b, c)