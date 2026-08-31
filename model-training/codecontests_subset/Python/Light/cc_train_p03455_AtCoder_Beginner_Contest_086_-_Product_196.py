print("Odd" if all([int(e) & 1 for e in input().strip().split()]) else "Even")
