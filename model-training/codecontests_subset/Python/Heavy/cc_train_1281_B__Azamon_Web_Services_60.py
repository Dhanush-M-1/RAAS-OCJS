def solve(s, c):
    smallest_after = []
    for i in range(len(s) - 1, -1, -1):
        if len(smallest_after) == 0:
            smallest_after.append((s[i], i))
        else:
            current_smallest, smallest_index = smallest_after[-1]
            if s[i] < current_smallest:
                current_smallest, smallest_index = s[i], i
            smallest_after.append((current_smallest, smallest_index))
    smallest_after = list(reversed(smallest_after))
    for i in range(len(s)):
        smallest_value, smallest_index = smallest_after[i]
        if smallest_value < s[i]:
            s = s[:i] + s[smallest_index] + s[i+1:smallest_index] + s[i] + s[smallest_index+1:]
            break
    return s if s < c else '---'

for T in range(int(input())):
    print(solve(*input().split()))
