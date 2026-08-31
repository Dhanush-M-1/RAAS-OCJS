#include <iostream>
#include <string>
using namespace std;

int main(void)
{
	int n, rank;
	bool card[4][13];
	char suit;
	string suits="SHCD";

	for (int i=0; i<4; i++)
		for (int j=0; j<13; ++j) 
			card[i][j] = true;

	cin >> n;
	for (int i=0; i<n; i++){
		cin >> suit >> rank;
		card[suits.find(suit)][rank-1] = false;
	}

	for (int i=0; i<4; i++)
		for (int j=0; j<13; j++) 
			if (card[i][j] == true)
				cout << suits.at(i) << " " << j+1 << endl;
	return 0;
}