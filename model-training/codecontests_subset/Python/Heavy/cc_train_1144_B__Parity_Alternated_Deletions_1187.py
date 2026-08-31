import heapq


def solve(numbers, parity):
    # split into even and odd numbers
    even_numbers = [-n for n in numbers if n % 2 == 0]
    heapq.heapify(even_numbers)
    odd_numbers = [-n for n in numbers if n % 2 == 1]
    heapq.heapify(odd_numbers)

    def remove_element(some_numbers):
        if len(some_numbers) == 0:
            return True
        heapq.heappop(some_numbers)
        return False

    stop = False
    while not stop:
        if parity == 0:
            stop = remove_element(even_numbers)
        elif parity == 1:
            stop = remove_element(odd_numbers)

        parity = 1 - parity

    # compute sum
    return - sum(even_numbers) - sum(odd_numbers)


def main():
    n = int(input().strip())
    numbers = list(map(int, input().strip().split()))

    even_r = solve(numbers, 0)
    odd_r = solve(numbers, 1)

    print(min(even_r, odd_r))

if __name__ == "__main__":
    main()
