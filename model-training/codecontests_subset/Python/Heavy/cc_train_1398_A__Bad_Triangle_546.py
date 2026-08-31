#!/usr/bin/env python
# -*- coding: utf-8 -*-
#
#  untitled.py
#  
#  Copyright 2020 Md Sidratul Muntaher Tibrow <smuntahar@gmail.com>
#  
#  This program is free software; you can redistribute it and/or modify
#  it under the terms of the GNU General Public License as published by
#  the Free Software Foundation; either version 2 of the License, or
#  (at your option) any later version.
#  
#  This program is distributed in the hope that it will be useful,
#  but WITHOUT ANY WARRANTY; without even the implied warranty of
#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#  GNU General Public License for more details.
#  
#  You should have received a copy of the GNU General Public License
#  along with this program; if not, write to the Free Software
#  Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
#  MA 02110-1301, USA.
#  
#  


def main(args):
	for i in range(int(input())):
		c = int(input())
		n = list(map(int, input().split(' ')))
		count = 0
		v = []
		if n[0] + n[1] > n[-1]:
			print(-1)
		else:
			print(1, 2, c)
		
	

if __name__ == '__main__':
    import sys
    sys.exit(main(sys.argv))
