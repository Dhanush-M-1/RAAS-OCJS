for _ in range(int(input())):
    poem = list(input())
    ans1 = 0
    index = 1
    poem.insert(0, "KEK")
    poem.append("KEWK")
    while index <= len(poem) - 2:
        if poem[index] == poem[index - 1]:
            ans1 += 1
            poem[index] = str(index)
            index += 1
        elif poem[index] == poem[index + 1]:
            ans1 += 1
            poem[index + 1] = str(index)
            index += 1
        elif poem[index - 1] == poem[index + 1]:
            ans1 += 1
            poem[index + 1] = str(index)
            index += 1
        else:
            index += 1
    print(ans1)

