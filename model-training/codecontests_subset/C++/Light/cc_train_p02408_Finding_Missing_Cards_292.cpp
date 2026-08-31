#include <iostream>
using namespace std;

int main(void)
{
	int n;
	int card[4][13] = {0};
	char mark[5] = "SHCD";

	cin >> n;

	for(int i = 0; i < n; i++) {
		char mark;
		int num;

		cin >> mark >> num;
		
		num --;
		switch(mark) {
		case 'S': card[0][num]++; break;
		case 'H': card[1][num]++; break;
		case 'C': card[2][num]++; break;
		case 'D': card[3][num]++; break;
		}
	}

	for(int i = 0; i < 4; i++)
		for(int j = 0; j < 13; j++)
			if(card[i][j] == 0)	cout << mark[i] << " " << j + 1 << endl;

	return 0;
}