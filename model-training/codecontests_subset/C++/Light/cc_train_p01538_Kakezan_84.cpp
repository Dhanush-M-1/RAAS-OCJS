#include <iostream>
#include <algorithm>

using namespace std;

int Q, N, C;

int digit(int n, int k = 0)
{
	if (n == 0) { return k; }

	return digit(n / 10, k + 1);
}

int power(int a, int b)
{
	if (b == 0) { return 1; }

	return power(a, b - 1) * a;
}

int main()
{
	cin >> Q;

	for (int i = 0; i < Q; i++)
	{
		cin >> N;

		C = 0;

		while (digit(N) > 1)
		{
			int Next_N = 0;

			for (int j = 1; j < digit(N); j++)
			{
				int l = N / power(10, j);
				int r = N % power(10, j);

				Next_N = max(l * r, Next_N);
			}

			N = Next_N;

			C++;
		}

		cout << C << endl;
	}

	return 0;
}