#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <numeric>

using namespace std;

void temp(int *x, int *y)
{
	int temp;
	temp = *x;
	*x = *y;
	*y = temp;
}

int main(void)
{
	int n;
	while(cin >> n && n != 0)
	{
		vector<int> a(n);
		for (int i = 0; i < n; ++i)
			cin >> a[i];

		int counter = 0;

		for (int i = n; i > 0; --i)
		{
			for(int k = 0;k < i-1;k++)
			{
				if(a[k] > a[k+1])
				{
					temp(&a[k], &a[k+1]);
					counter++;
				}
			}
		}

		cout << counter << endl;
	}

	return 0;
}
