#include<iostream>
using namespace std;

int main()
{
	const int TYPENUM = 4;
	const int RANKNUM = 13;
	bool card[TYPENUM][RANKNUM] = { false };
	char type[] = { "SHCD" };
	int n;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		char c;
		int r;
		int idx;
		cin >> c >> r;
		if (c == 'S')
			idx = 0;
		else if (c == 'H')
			idx = 1;
		else if (c == 'C')
			idx = 2;
		else if (c == 'D')
			idx = 3;
		card[idx][r-1] = true;
	}
	for (int i = 0; i < 4; i++)
		for (int j = 0; j <13; j++)
			if (card[i][j] == false)
				cout << type[i] << " " << j+1 << endl;
}
