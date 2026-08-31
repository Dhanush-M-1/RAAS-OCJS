#include "iostream"
using namespace std;

int main()
{
	int n;
	cin >> n;
	char shurui[] = "SHCD";
	int card[52];
	for (int i = 0; i < 52; i++)
	{
		card[i] = 0;
	}
	for (int i = 0; i < n; i++)
	{
		int a; char b;
		cin >> b >> a;
		for (int j = 0; j < 4; j++)
		{
			if (b == shurui[j]) {
				card[13*j + a-1] = 1;
			}
		}
	}
	for (int i = 0; i < 52; i++)
	{
		if (card[i] == 0) {
			cout << shurui[i / 13] << " " << i % 13+1<<endl;
		}
	}

	return 0;
}