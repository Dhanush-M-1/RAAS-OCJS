if __name__ == "__main__":
    test_cases = int(input())
    for case in range(test_cases):
        peeks = int(input())
        plays = []
        clears = []
        prev_play = 0
        prev_clear = 0
        flag = True
        for peek in range(peeks):
            play, clear = [(int(s)) for s in input().split()]
            play_del = abs(prev_play - play)
            clear_del = abs(prev_clear - clear)
            if not (play >= prev_play and clear >= prev_clear and clear <= play):
                flag = False
            elif play_del < clear_del:
                flag = False
            prev_play = play
            prev_clear = clear

        if flag:
            print("YES")
        else:
            print("NO")




