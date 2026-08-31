def main():
    state = dict.fromkeys(input().split())
    print(' '.join(list(state.keys())))

    for _ in range(int(input())):
        next_choices = input().split()
        del state[next_choices[0]]
        state[next_choices[1]] = 0
        print(' '.join(list(state.keys())))


if __name__ == '__main__':
    main()
