#include <bits/stdc++.h>
using namespace std;

int	main()
{
	int	n;
	cin >> n;
	map<char, vector<bool> > lost_cards;
	char	suits[] = "SHCD";
	for (int j = 0; j < 4; ++j)
		lost_cards[suits[j]] = vector<bool>(13, true);
	char	suit;
	int		rank;
	for (int i = 0; i < n; ++i) {
		cin >> suit >> rank;
		lost_cards.at(suit).at(rank - 1) = false;
	}
	for (int j = 0; j < 4; ++j) {
		for (int i = 0; i < 13; ++i) {
			if (lost_cards.at(suits[j]).at(i))
				cout << suits[j] << " " << i + 1 << endl;
		}
	}
}	
