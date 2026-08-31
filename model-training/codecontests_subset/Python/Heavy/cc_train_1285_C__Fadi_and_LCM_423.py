def sq(val):
    sq_val = 1
    while (sq_val * sq_val) <= val:
        sq_val += 1
    return sq_val


def find_primes_until(val):
    sieve = [None] * val
    primes = []
    start = 1
    while start < val:
        if sieve[start] is None:
            primes.append(start + 1)
        for index in range(start, val, start + 1):
            sieve[index] = True
        start += 1
    return primes


def solve(val):
    sq_val = sq(val)
    primes = find_primes_until(sq_val)
    # print(primes)
    primes_map = {}
    for prime in primes:
        count = 0
        while val % prime == 0:
            count += 1
            val /= prime
        if count > 0:
            primes_map[prime] = count
        if val == 1:
            break

    if val != 1:
        primes_map[val] = 1

    keys = list(primes_map.keys())

    def calculate_min(index, divider1, divider2):
        if index == len(keys):
            return divider1, divider2
        tuple1 = calculate_min(index + 1, divider1, divider2 * keys[index] ** primes_map[keys[index]])
        tuple2 = calculate_min(index + 1, divider1 * keys[index] ** primes_map[keys[index]], divider2)
        if max(tuple1) < max(tuple2):
            return tuple1
        else:
            return tuple2

    t = calculate_min(0, 1, 1)
    print(int(t[0]), int(t[1]))


solve(int(input()))
