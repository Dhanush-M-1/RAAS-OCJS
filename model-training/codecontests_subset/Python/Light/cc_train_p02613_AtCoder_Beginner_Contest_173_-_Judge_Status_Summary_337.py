n = int(input())
s = [input() for i in range(n)]
print(f"AC x {s.count('AC')}\nWA x {s.count('WA')}\nTLE x {s.count('TLE')}\nRE x {s.count('RE')}")
