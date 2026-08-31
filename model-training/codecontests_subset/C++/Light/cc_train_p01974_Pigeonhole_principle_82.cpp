#include <iostream>
#include <math.h>
#include <stdio.h>
#include <string>
#include <string.h>
#include <algorithm>
#include <cmath>
#include <limits>
#include <sstream>

using namespace std;

int main (void)
{
	long n,a[10000];

	cin >> n;

	for (long i = 0; i < n; i++)
	{
		cin >> a[i];
	}

	int p = 0;

	sort(a,a + n);

	for (long i = 0; i < n; i++)
	{
		for (long j = 0; j < n; j++)
		{
			if (i < j && (a[j] - a[i]) % (n - 1) == 0)
			{
				cout << a[i] << " " << a[j] << endl;
				p += 1;
				break;
			}
		}
		if (p != 0)
		{
			break;
		}
	}
}
