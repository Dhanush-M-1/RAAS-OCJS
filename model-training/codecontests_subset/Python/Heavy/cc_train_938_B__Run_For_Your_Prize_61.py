my_position = 1
friend_position = 10 ** 6

if __name__ == '__main__':
    count = int(input())
    prize = input().split(' ')
    time = 0
    last = len(prize)
    index_for_me = 0
    index_for_friend = len(prize) - 1
    for i in range(0, last):
        my_path = int(prize[index_for_me]) - my_position
        friend_path = friend_position - int(prize[index_for_friend])
        if my_path < friend_path:
            min_path = my_path
            index_for_me += 1
        else:
            min_path = friend_path
            index_for_friend -= 1
        time += min_path
        my_position += min_path
        friend_position -= min_path
    print(time)