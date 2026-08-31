from collections import Counter

alphabet = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']


def get_buttons_pressed_stat(combo_length, combo, failed_times, failed_data):
    failed_data_sorted = sorted(failed_data, reverse=True)
    button_pressed = Counter()

    latest_failed_amount = failed_times
    latest_failed_button = None
    if failed_times != 0:
        latest_failed_button = failed_data_sorted.pop()

    for i in range(combo_length):
        increment_amount = 1
        while latest_failed_button is not None and latest_failed_button - 1 < i:
            latest_failed_amount -= 1
            if len(failed_data_sorted) == 0:
                latest_failed_button = None
            else:
                latest_failed_button = failed_data_sorted.pop()
        button_pressed[combo[i]] += increment_amount + latest_failed_amount

    return button_pressed


number_of_tests = int(input())
for _ in range(number_of_tests):
    n, m = tuple(map(int, input().split()))
    s = input()
    p = list(map(int, input().split()))
    buttons_pressed_stat = get_buttons_pressed_stat(n, s, m, p)
    for button in alphabet:
        if button == 'z':
            print(buttons_pressed_stat[button])
        else:
            print(buttons_pressed_stat[button], end=' ')
