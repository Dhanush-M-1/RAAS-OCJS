# Problem 1547C

if __name__ == '__main__':
    for _ in range(int(input())):
        input()  # Skip line

        k, n, m = [int(i) for i in input().split(" ")]
        a = [int(i) for i in input().split(" ")]
        b = [int(i) for i in input().split(" ")]
        sequence = [""] * (n + m)
        i, j = 0, 0

        while True:
            # Create new line if possible, if not try to modifying an existing line
            if i < n and a[i] == 0:
                sequence[i+j] = "0"
                k += 1
                i += 1
            elif j < m and b[j] == 0:
                sequence[i+j] = "0"
                k += 1
                j += 1
            elif i < n and a[i] <= k:
                sequence[i+j] = str(a[i])
                i += 1
            elif j < m and b[j] <= k:
                sequence[i+j] = str(b[j])
                j += 1
            else:
                # Either trying to modify lines that do not exist yet with no possibility of creating them
                # or successfully completed all actions
                break

        if i == n and j == m:
            # Didn't break early
            print(" ".join(sequence))
        else:
            # Broke from loop early
            print("-1")

