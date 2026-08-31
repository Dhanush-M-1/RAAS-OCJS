# -*- coding: utf-8 -*-
"""
Created on Sat Jan 18 21:04:56 2020

@author: jared
"""
_ = input()
print(25)
# =============================================================================
# Editorial
# 
# 630A - Again Twenty Five!
# 
# The problem of getting the last two digits is equivalent to the problem of 
# getting the number modulo 100. So we need to calculate 5^n mod 100. According 
# to the rules of modular arithmetic
# 
# (a * b) mod c = ((a mod c) * (b mod c)) mod c
# 
# So
# 
# 5^n mod 100 = ((5^(n-1) mod 100) * 5) mod 100
# 
# Let's note that 52 = 25. Then
# 
# 5^3 mod 100 = ((5^2 mod 100) * 5) mod 100 = (25 * 5) mod 100 = 25
# 5^4 mod 100 = ((5^3 mod 100) * 5) mod 100 = (25 * 5) mod 100 = 25
# 
# And so on. All 5^n mod 100 are equal to 25 for all n >= 2.
# 
# So to solve the problem one need to just output 25. There is no need to read n.
# 
# =============================================================================