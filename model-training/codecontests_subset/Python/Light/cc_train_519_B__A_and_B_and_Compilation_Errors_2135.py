def loop(list_one, list_two):
    A = sorted(list_one)
    B = sorted(list_two)
    for i in A:
        if i in B:
            B.remove(i)
            continue
        return i


main_line = int(input())
first_line = [int(i) for i in input().split(" ")]
second_line = [int(j) for j in input().split(" ")]
third_line = [int(k) for k in input().split(" ")]

print(loop(first_line, second_line))
print(loop(second_line, third_line))