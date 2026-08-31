#include<iostream>
using namespace std;

int main()
{
	int n;
	char suits[4] = { 'S', 'H', 'C', 'D' };
	bool d[4][13] = { false };

	cin >> n;

	for (int i = 0; i < n; i++)
	{
		char mark;
		int A;

		cin >> mark >> A;

		if (mark == suits[0]) d[0][A - 1] = true;
		else if (mark == suits[1]) d[1][A - 1] = true;
		else if (mark == suits[2]) d[2][A - 1] = true;
		else if (mark == suits[3]) d[3][A - 1] = true;

	}

	for (int i = 0; i < 4; i++)
	{
		for (int j = 0; j < 13; j++)
		{
			if (d[i][j] == false) cout << suits[i] << " " << j + 1 << "\n";
		}
	}

	return 0;
}