#include <iostream>

using namespace std;

int main(void)
{
	int q;
	cin >> q;

	int n;
	for(int i = 0; i < q; i++)
	{
		cin >> n;
		
		int counter = 0;

		while(n >= 10)
		{
			int x, max = 0;

			for(int j = 10; j < n; j *= 10)
			{
				x = (n / j) * (n % j);

				if(x >= max)
					max = x;
			}
			n = max;
			counter++;
		}
		cout << counter << endl;
	}

	return 0;
}
