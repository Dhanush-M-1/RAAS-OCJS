#include <iostream>
using namespace std;
int main()
{
	int n, m[100], i, j, c;
	while (cin >> n && n)
	{
		c = 0;
		for (i = 0; i < n; i++)
			cin >> m[i];
		for (i = 0; i < n; i++)
		{
			for (j = 0; j < n-1; j++)
			{
				if (m[j] > m[j+1])
				{
					swap(m[j], m[j+1]);
					c++;
				}
			}
		}
		cout << c << endl;
	}
}