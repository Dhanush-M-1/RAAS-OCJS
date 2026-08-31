def main():
    n, k = map(int, input().split())
    alice_counter = k
    bob_counter = k
    total_time = 0
    both = []
    alice = []
    bob = []
    for _ in range(n):
        t, a, b = map(int, input().split())
        if a and b:
            both.append(t)
        elif a:
            alice.append(t)
        elif b:
            bob.append(t)
    both = sorted(both)
    alice = sorted(alice)
    bob = sorted(bob)
    pointer = [0] * 3
    while True:
        if bob_counter == 0 and alice_counter == 0:
            return total_time
        if pointer[1] >= len(alice) or pointer[2] >= len(bob):
            while bob_counter > 0 or alice_counter > 0:
                if pointer[0] >= len(both):
                    return -1
                total_time += both[pointer[0]]
                pointer[0] += 1
                bob_counter -= 1
                alice_counter -= 1
            return total_time

        elif pointer[0] >= len(both):
            while bob_counter > 0 or alice_counter > 0:
                if pointer[1] >= len(alice) or pointer[2] >= len(bob):
                    return -1
                total_time += alice[pointer[1]] + bob[pointer[2]]
                pointer[1] += 1
                pointer[2] += 1
                bob_counter -= 1
                alice_counter -= 1
            return total_time
        else:
            if both[pointer[0]] > alice[pointer[1]] + bob[pointer[2]]:
                total_time += alice[pointer[1]] + bob[pointer[2]]
                pointer[1] += 1
                pointer[2] += 1
            else:
                total_time += both[pointer[0]]
                pointer[0] += 1
            bob_counter -= 1
            alice_counter -= 1

print(main())
