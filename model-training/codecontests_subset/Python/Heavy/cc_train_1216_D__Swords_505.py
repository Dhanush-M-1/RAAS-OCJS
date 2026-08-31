try:
    from string_source import string_source

    source = string_source(
        """6
13 52 0 13 26 52"""
    )

except ImportError:
    source = input

import math


def swords(a_left):
    m = max(a_left)
    a_stolen = [m - a for a in a_left]
    g = a_stolen[0]
    for a in a_stolen[1:]:
        if g == 1:
            break

        g = math.gcd(g, a)

    return sum(a_stolen) // g, g

source()

people, sword_per_people = swords(list(map(int, source().split(" "))))
print(people, sword_per_people)
