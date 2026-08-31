def main():
    n, k = map(int, input().split())
    content= sorted(map(int, input().split()))

    double = 0
    answer = 1
    if len(content) == 1:
        print(1)
        return

    j = 1
    while j < len(content):
        if content[j] > content[j - 1]:
            if content[j] > content[j - 1] + k:
              answer += double + 1
            double = 0
        elif content[j] == content[j - 1]:
            double += 1
        j += 1

    if (double):
        answer += double

    print(answer)

main()