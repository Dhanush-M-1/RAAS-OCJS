def split(s):
    for i in range(len(s)):
        first = s[:i]
        second = s[i:]
        nums_first = [first.count('0'), first.count('1')]
        nums_second = [second.count('0'), second.count('1')]
        #print(nums_first, nums_second)
        if nums_first[0] != nums_first[1] and nums_second[0] != nums_second[1]:
            answer = first + ' ' + second
            return answer
        elif nums_first == [0, 0] and nums_second[0] != nums_second[1]:
            answer = second
            return answer
        elif nums_second == [0, 0] and nums_first[0] != nums_first[1]:
            answer = first
            return first
        else:
            print()
    return

_ = input()
s = input()
s = str(split(s))
print(s.count(' ') + 1)
print(s)
