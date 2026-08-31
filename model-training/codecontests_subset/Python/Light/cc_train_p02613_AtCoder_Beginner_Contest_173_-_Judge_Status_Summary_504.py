N=int(input())
A=[input() for _ in range(N)]

print("AC x",A.count("AC"),"\nWA x",A.count("WA"), "\nTLE x",A.count("TLE"), "\nRE x",A.count("RE"))
