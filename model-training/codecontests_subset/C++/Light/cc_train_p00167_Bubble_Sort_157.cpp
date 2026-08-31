#include <iostream>
#include <math.h>
#include <algorithm>
#include <stdio.h>
#include <string>
#include <vector>
#include <queue>
using namespace std;

int main()
{
	int n;
	int a[100];
	while (cin >> n)
	{
		if (n == 0)
		{
			return 0;
		}
		int cnt = 0;
		for (int i = 0; i < n; i++)
		{
			cin >> a[i];
		}

		for (int i = 0 ; i < n ; i++)
		{
			for (int j = 0; j < n - 1 - i; j++)
			{
				if (a[j] > a[j + 1])
				{
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					cnt++;
				}
			}
		}
		cout << cnt << endl;
	}

	sort(a, a + n);
	for (int i = 0; i < n; i++)
	{
		cout << a[i];
		if ( i != n - 1)
		{
			cout << " ";
		}
	}
	cout << endl;
	return 0;
}